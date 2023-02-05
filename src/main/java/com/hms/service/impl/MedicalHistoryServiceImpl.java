package com.hms.service.impl;

import com.hms.entites.MedicalHistory;
import com.hms.payload.MedicalHistoryDto;
import com.hms.repository.MedicalRepository;
import com.hms.repository.PatientRepository;
import com.hms.service.MedicalHistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MedicalHistoryServiceImpl implements MedicalHistoryService {
    private MedicalRepository medicalRepository;
    private PatientRepository patientRepository;

    public MedicalHistoryServiceImpl(MedicalRepository medicalRepository,PatientRepository patientRepository) {
        this.medicalRepository=medicalRepository;
        this.patientRepository=patientRepository;
    }


    @Override
    public MedicalHistory medicalFindId(long patientId) {
        MedicalHistory g = medicalRepository.findByPatientId(patientId);
        return g;
    }
}
