package com.hms.repository;

import com.hms.entites.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InsuranceRepository extends JpaRepository<Insurance,Long> {
 List<Insurance> findByPatientId(long patientId);
}
