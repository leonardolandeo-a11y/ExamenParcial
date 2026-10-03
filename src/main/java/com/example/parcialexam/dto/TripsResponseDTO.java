package com.example.parcialexam.dto;

import com.example.parcialexam.model.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TripsResponseDTO {
    private Long id;
    private String origin;
    private String destination;
    private Integer availableSeats;
    private Status status;
}
