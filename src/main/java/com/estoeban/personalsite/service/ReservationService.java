package com.estoeban.personalsite.service;

import com.estoeban.personalsite.model.Reservation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ReservationService {

    Flux<Reservation> getAllReservations();

    Mono<Reservation> getReservation(String id);

    Mono<Reservation> createReservation(Mono<Reservation> reservationMono);

    Mono<Reservation> updateReservation(String id, Mono<Reservation> reservationMono);

    Mono<Boolean> deleteReservation(String id);

}
