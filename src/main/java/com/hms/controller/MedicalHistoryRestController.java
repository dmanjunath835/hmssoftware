package com.hms.controller;

import com.hms.entites.MedicalHistory;
import com.hms.service.MedicalHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class MedicalHistoryRestController {
    @Autowired
    private MedicalHistoryService medicalHistoryService;

    @GetMapping("/patient/{patientId}/medical")
    public ResponseEntity<MedicalHistory> createPatientId(@PathVariable(value="patientId") long patientId){
        MedicalHistory f = medicalHistoryService.medicalFindId(patientId);

        return new ResponseEntity<>(f, HttpStatus.OK);
    }



}
