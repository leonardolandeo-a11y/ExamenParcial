package com.example.parcialexam.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TripsRequestDTO {
    @NotBlank
    private String origin;
    @NotBlank
    private String destination;
    @Future
    private ZonedDateTime departureTime;
    @Min(1)
    @Max(6)
    private Integer capacity;
}
