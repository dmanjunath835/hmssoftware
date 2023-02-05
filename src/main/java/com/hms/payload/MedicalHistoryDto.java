package com.hms.payload;

import com.hms.entites.Patient;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class MedicalHistoryDto {
    private Long id;
    private String allergies;
    private String previousIllnesses;
    private String currentMedications;
}
