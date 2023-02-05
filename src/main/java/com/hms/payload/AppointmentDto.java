package com.hms.payload;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentDto {
    private Long id;
    private LocalDateTime appointmentDate;
    private String reasonForVisit;
}
