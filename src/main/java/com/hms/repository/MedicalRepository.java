package com.hms.repository;

import com.hms.entites.MedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MedicalRepository extends JpaRepository<MedicalHistory,Long> {
   MedicalHistory findByPatientId(long patientId);
}
