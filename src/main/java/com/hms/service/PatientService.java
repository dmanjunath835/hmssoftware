package com.hms.service;

import com.hms.entites.Patient;
import com.hms.payload.PatientDto;

import java.util.List;

public interface PatientService {
 public Patient createPatient(PatientDto patientDto);

    List<Patient> getAll();

    Patient findByPatientId(long id);
}
