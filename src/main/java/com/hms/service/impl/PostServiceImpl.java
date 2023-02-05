package com.hms.service.impl;

import com.hms.entites.*;
import com.hms.exception.ResourceNotFoundException;
import com.hms.payload.PatientDto;
import com.hms.repository.*;
import com.hms.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PatientService {
    @Autowired
    private InsuranceRepository insuranceRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private MedicalRepository medicalRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private BillingRepository billingRepository;

    @Override
    public Patient createPatient(PatientDto patientDto) {
        Patient patient=new Patient();
        patient.setName(patientDto.getName());
        patient.setGender(patientDto.getGender());
        patient.setDateOfBirth(patientDto.getDateOfBirth());
        Patient patients = patientRepository.save(patient);

        MedicalHistory medicalHistory=new MedicalHistory();
        medicalHistory.setPatient(patients);
        medicalHistory.setAllergies(patientDto.getMedicalHistory().getAllergies());
       medicalHistory.setPreviousIllnesses(patientDto.getMedicalHistory().getPreviousIllnesses());
       medicalHistory.setCurrentMedications(patientDto.getMedicalHistory().getCurrentMedications());
       medicalRepository.save(medicalHistory);

        patientDto.getAppointments().forEach(appointmentDto -> {
            Appointment appointment=new Appointment();
            appointment.setPatient(patients);
            appointment.setAppointmentDate(appointmentDto.getAppointmentDate());
            appointment.setReasonForVisit(appointmentDto.getReasonForVisit());
            appointmentRepository.save(appointment);
        });


        Billing billing=new Billing();
        billing.setPatient(patients);
       billing.setInsuranceProvider(patientDto.getBilling().getInsuranceProvider());
       billing.setPolicyNumber(patientDto.getBilling().getPolicyNumber());
       billing.setTotalAmount(patientDto.getBilling().getTotalAmount());
       billingRepository.save(billing);

//        Insurance insurance=new Insurance();
//        insurance.setPatient(patients);
//      insurance.setName(patientDto.getInsurances().get(0).getName());
//      insurance.setPolicyType(patientDto.getInsurances().get(1).getPolicyType());
//      insurance.setPhoneNumber(patientDto.getInsurances().get(2).getPhoneNumber());
//      insurance.setAddress(patientDto.getInsurances().get(3).getAddress());
//           insuranceRepository.save(insurance);
    patientDto.getInsurances().forEach(insuranceDto -> {
        Insurance insurance=new Insurance();
        insurance.setPatient(patients);
        insurance.setName(insuranceDto.getName());
        insurance.setPolicyType(insuranceDto.getPolicyType());
        insurance.setPhoneNumber(insuranceDto.getPhoneNumber());
        insurance.setAddress(insuranceDto.getAddress());
        insuranceRepository.save(insurance);
    });
        return patients;
    }

    @Override
    public List<Patient> getAll() {
       return   patientRepository.findAll();
    }

    @Override
    public Patient findByPatientId(long id) {
        Patient pa = patientRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("patient", "id", id));


        return pa;
    }
}
