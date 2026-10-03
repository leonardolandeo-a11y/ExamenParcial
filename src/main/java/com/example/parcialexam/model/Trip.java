package com.example.parcialexam.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "trip")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private ZonedDateTime departureTime;
    @Column(nullable = false)
    private Integer capacity;
    @Column(nullable = false)
    private Integer availableSeats;
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "trip")
    private List<Route> route;


    @OneToOne(mappedBy = "trip")
    private SeatRequest seatRequest;

}
