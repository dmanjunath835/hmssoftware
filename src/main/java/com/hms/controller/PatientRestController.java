package com.hms.controller;

import com.hms.entites.Patient;
import com.hms.payload.PatientDto;
import com.hms.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientRestController {
    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<Object>createPatient(@RequestBody PatientDto patientDto, BindingResult bindingResult){

        if(bindingResult.hasErrors()){

            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.CREATED);


        }

        return new ResponseEntity<>(patientService.createPatient(patientDto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Patient> getAll(){

        return patientService.getAll();
    }

@GetMapping("/{id}")
    public ResponseEntity<Patient>getPatientId(@PathVariable(name="id")long id){
    Patient s = patientService.findByPatientId(id);
    return new ResponseEntity<>(s,HttpStatus.OK);
}

}
