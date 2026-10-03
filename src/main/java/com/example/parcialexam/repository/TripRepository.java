package com.example.parcialexam.repository;

import com.example.parcialexam.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip,Long> {
}
