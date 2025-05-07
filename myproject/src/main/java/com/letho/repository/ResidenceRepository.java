package com.letho.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.letho.model.Residence;

import java.util.Optional;

@Repository
public interface ResidenceRepository extends JpaRepository<Residence, Long> {

    // Query to find a residence by user ID
    Optional<Residence> findByUserId(Long userId);

    // Query to find a residence by name (for choosing another residence)
    Optional<Residence> findByName(String name);

}