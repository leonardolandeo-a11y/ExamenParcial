package com.example.parcialexam.controller;

import com.example.parcialexam.dto.TripsRequestDTO;
import com.example.parcialexam.dto.TripsResponseDTO;
import com.example.parcialexam.model.Trip;
import com.example.parcialexam.service.TripsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
@RestController
@AllArgsConstructor
public class TripController {
    private final TripsService tripsService;


    @PostMapping("/trips")
    public ResponseEntity<TripsResponseDTO> createTrip(@Valid @ResponseBody TripsRequestDTO tripsRequestDTO){
        TripsResponseDTO tripsResponseDTO = tripsService.createTrip(tripsRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(tripsResponseDTO);
    }
    @GetMapping
    public ResponseEntity<Page<Trip>> getAllProducts(
            @PageableDefault(page = 0, size = 5) Pageable pageable) {

        Page<Trip> productsPage = tripsService.getAllProducts(pageable);
        return ResponseEntity.ok(productsPage);
    }
}
