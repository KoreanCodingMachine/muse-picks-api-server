package com.kjh.musepicks.repository;

import com.kjh.musepicks.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
