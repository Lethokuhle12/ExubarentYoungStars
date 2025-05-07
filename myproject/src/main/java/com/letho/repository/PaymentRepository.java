package com.letho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.letho.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    // Query to find payment by user ID
    Payment findByUserId(Long userId);

    // Query to check payment status for a specific user
    boolean existsByUserIdAndPaymentStatus(Long userId, boolean paymentStatus);
}
