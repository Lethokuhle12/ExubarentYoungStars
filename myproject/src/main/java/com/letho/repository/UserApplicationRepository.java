package com.letho.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.letho.model.UserApplication;

@Repository
public interface UserApplicationRepository extends JpaRepository<UserApplication, Long> {

 

    // Query to find a UserApplication by email (if needed for verification)
    Optional<UserApplication> findByEmail(String email);

    // Custom query to update user details (already done with save method)
    // UserApplication save(UserApplication userApplication); // Inherited from JpaRepository
}