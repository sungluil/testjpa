package com.example.testjpa.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class DateDTO {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate joinedAt;
}
