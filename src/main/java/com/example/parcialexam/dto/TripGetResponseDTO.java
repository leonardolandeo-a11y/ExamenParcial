package com.example.parcialexam.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TripGetResponseDTO {
    private Long id;
    private String username;
    private String destination;
    private Integer availableSeats;
}
