package com.letho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letho.repository.DocumentRepository;
import com.letho.repository.PaymentRepository;
import com.letho.repository.ResidenceRepository;
import com.letho.repository.UserApplicationRepository;


import com.letho.model.Document;
import com.letho.model.Residence;
import com.letho.model.UserApplication;

@Service
public class ApplicationService {

    @Autowired private UserApplicationRepository UserAppRepo;
    @Autowired private PaymentRepository paymentRepo;
    @Autowired private DocumentRepository documentRepo;
    @Autowired private ResidenceRepository residenceRepo;

    public boolean isPaymentConfirmed(Long userId){
        return paymentRepo.existsByUserIdAndPaymentStatus(userId, true);
    }

    private boolean isPaymentRequired(String fundingType) {
        return "self funded".equalsIgnoreCase(fundingType);
    }

    public UserApplication getUserApplication(Long userId){
        return UserAppRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void updateUserApplication(Long userId, UserApplication updatedApp) {
        UserApplication existingApp = getUserApplication(userId);
        if (!isPaymentRequired(existingApp.getFunding()) || isPaymentConfirmed(userId)) {
            UserAppRepo.save(updatedApp);
        } else {
            throw new RuntimeException("Payment not confirmed. Cannot update details.");
        }
    }

    public void reUploadDocument(Long userId, String documentType, Document newDoc) {
        UserApplication userApp = getUserApplication(userId);
        if (!isPaymentRequired(userApp.getFunding()) || isPaymentConfirmed(userId)) {
            Document existingDoc = documentRepo.findByUserIdAndDocumentType(userId, documentType);
            existingDoc.setFilePath(newDoc.getFilePath());
            documentRepo.save(existingDoc);
        } else {
            throw new RuntimeException("Payment not confirmed. Cannot upload documents.");
        }
    }

    public void changeResidence(Long userId, String newResidenceName) {
        UserApplication userApp = getUserApplication(userId);
        if (!isPaymentRequired(userApp.getFunding()) || isPaymentConfirmed(userId)) {
            Residence newResidence = residenceRepo.findByName(newResidenceName)
                    .orElseThrow(() -> new RuntimeException("Residence not found"));
            Residence currentResidence = residenceRepo.findByUserId(userId)
                    .orElseThrow(() -> new RuntimeException("Residence not assigned"));
            currentResidence.setName(newResidence.getName());
            currentResidence.setRoomNumber(newResidence.getRoomNumber());
            residenceRepo.save(currentResidence);
        } else {
            throw new RuntimeException("Payment not confirmed. Cannot change residence.");
        }
    }

    public List<Document> getUserDocuments(Long userId) {
        return documentRepo.findByUserId(userId);
    }

    public Residence getUserResidence(Long userId) {
        return residenceRepo.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Residence not found for user"));
    }
}
