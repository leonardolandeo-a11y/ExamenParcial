package com.example.parcialexam.service;

import com.example.parcialexam.dto.TripsRequestDTO;
import com.example.parcialexam.dto.TripsResponseDTO;
import com.example.parcialexam.exceptions.TripFullException;
import com.example.parcialexam.model.Trip;
import com.example.parcialexam.model.User;
import com.example.parcialexam.repository.TripRepository;
import com.example.parcialexam.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.Objects;

@Service
@AllArgsConstructor
public class TripsService {
    private final TripRepository tripRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @PreAuthorize("hasRole('ROLE_DRIVER')")
    public TripsResponseDTO createTrip(TripsRequestDTO tripsRequestDTO){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username).orElseThrow();

        if (Objects.equals(tripsRequestDTO.getOrigin(), tripsRequestDTO.getOrigin())){
            throw new TripFullException("Destination == origin");
        }
        return modelMapper.map(tripsRequestDTO,TripsResponseDTO.class);
    }
    public Page<Trip> getAllProducts(Pageable pageable) {
        return tripRepository.findAll(pageable);
    }

}
