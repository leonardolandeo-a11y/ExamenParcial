package com.example.parcialexam.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Entity
@Table(name = "route")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeatRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private ZonedDateTime requestedAt;
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @OneToOne
    @JoinColumn(name = "passager_id")
    private User passager;
}
