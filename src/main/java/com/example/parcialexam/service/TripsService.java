package com.example.parcialexam.service;

import com.example.parcialexam.dto.TripGetResponseDTO;
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
import org.springframework.web.bind.annotation.RequestParam;

import java.time.ZonedDateTime;
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
    public Page<TripGetResponseDTO> getAllProducts(String origin,
                                                   String destination,
                                                   ZonedDateTime from, Pageable pageable) {
        Page<Trip> productsPage = tripRepository.findAll(pageable);

        // Transforma la Page de entidades a una Page de DTOs
        return productsPage.map(product -> modelMapper.map(product, TripGetResponseDTO.class));
    }

}
