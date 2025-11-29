package com.example.fooddonation.repository;

import com.example.fooddonation.entity.DonationDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DonationRepository extends JpaRepository<DonationDTO, Integer> {

    // fetch donor and ngo to avoid lazy loading issues when returning DTO to client
    @Query("SELECT d FROM DonationDTO d LEFT JOIN FETCH d.donor LEFT JOIN FETCH d.ngo WHERE d.donor.id = :donorId ORDER BY d.id DESC")
    List<DonationDTO> findByDonorId(@Param("donorId") int donorId);

    @Query("SELECT d FROM DonationDTO d LEFT JOIN FETCH d.donor LEFT JOIN FETCH d.ngo WHERE d.ngo.id = :ngoId ORDER BY d.id DESC")
    List<DonationDTO> findByNgoId(@Param("ngoId") int ngoId);
}
