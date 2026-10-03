package com.example.parcialexam.controller;

import com.example.parcialexam.dto.TripGetResponseDTO;
import com.example.parcialexam.dto.TripsRequestDTO;
import com.example.parcialexam.dto.TripsResponseDTO;
import com.example.parcialexam.model.Trip;
import com.example.parcialexam.service.TripsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import java.time.ZonedDateTime;

@RestController
@AllArgsConstructor
public class TripController {
    private final TripsService tripsService;


    @PostMapping("/trips")
    public ResponseEntity<TripsResponseDTO> createTrip(@Valid @RequestBody TripsRequestDTO tripsRequestDTO){
        TripsResponseDTO tripsResponseDTO = tripsService.createTrip(tripsRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(tripsResponseDTO);
    }
    @GetMapping
    public ResponseEntity<Page<Trip>> getAllProducts(
            @RequestParam(required = false) String origin,
            @RequestParam(required = false) String destination,
            @RequestParam(required = false) ZonedDateTime from,
            @PageableDefault(page = 0, size = 10) Pageable pageable) {

        Page<TripGetResponseDTO> productsPage = tripsService.getAllTrips(origin,destination,from,pageable);
        
        return ResponseEntity.status(HttpStatus.OK).body(productsPage);
    }
}
