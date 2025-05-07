package com.letho.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class UserApplication {
    @Id
    private Long userId;
    private String fullName;
    private String gender;
    private String phone;
    private String email;
    private String campus;
    private String funding;
    private Long residenceId;
    private Long documentId;
    private Long paymentId;

       
    public UserApplication() {
        
    }

  
    public UserApplication(Long userId, String fullName, String gender, String phone, String email,
                           String campus, String funding, Long residenceId, Long documentId,Long paymentId) {
        this.userId = userId;
        this.fullName = fullName;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.campus = campus;
        this.funding = funding;
        this.residenceId = residenceId;
        this.documentId = documentId;
        this.paymentId = paymentId;
    }

    
      // Getters and Setters


    public void setPaymentId(Long paymentId){
        
        this.paymentId = paymentId;

    }

    public Long getPaymentId(){
         return paymentId;
    }
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getFunding() {
        return funding;
    }

    public void setFunding(String funding) {
        this.funding = funding;
    }

    public Long getResidenceId() {
        return residenceId;
    }

    public void setResidenceId(Long residenceId) {
        this.residenceId = residenceId;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }
}
