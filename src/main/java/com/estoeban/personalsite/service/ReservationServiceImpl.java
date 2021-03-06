package com.estoeban.personalsite.service;

import com.estoeban.personalsite.model.Reservation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReactiveMongoOperations reactiveMongoOperations;

    @Autowired
    public ReservationServiceImpl(ReactiveMongoOperations reactiveMongoOperations) {
        this.reactiveMongoOperations = reactiveMongoOperations;
    }

    @Override
    public Flux<Reservation> getAllReservations() {
        log.debug("Fetching All Reservations");
        return reactiveMongoOperations.findAll(Reservation.class);
    }

    @Override
    public Mono<Reservation> getReservation(String id) {
        log.debug("Fetching Reservation of id: {}", id);
        return reactiveMongoOperations.findById(id, Reservation.class);
    }

    @Override
    public Mono<Reservation> createReservation(Mono<Reservation> reservationMono) {
        log.debug("Creating Reservation: {}", reservationMono);
        return reactiveMongoOperations.save(reservationMono);
    }

    @Override
    public Mono<Reservation> updateReservation(String id, Mono<Reservation> reservationMono) {
        log.debug("Updating Reservation: {}", reservationMono);
        return reactiveMongoOperations.save(reservationMono);

        //        return reservationMono.flatMap(reservation -> {
        //            return reactiveMongoOperations.findAndModify(
        //                Query.query(Criteria.where("id").is(id)),
        //                Update.update("price", reservation.getPrice()).set("checkIn", reservation.getCheckIn()).set("checkOut", reservation.getCheckOut()),
        //                Reservation.class
        //            ).flatMap(result -> {
        //                result.setPrice(reservation.getPrice());
        //                result.setCheckIn(reservation.getCheckIn());
        //                result.setCheckOut(reservation.getCheckOut());
        //                return Mono.just(result);
        //            });
        //        });
    }

    @Override
    public Mono<Boolean> deleteReservation(String id) {
        return reactiveMongoOperations.remove(
            Query.query(Criteria.where("id").is(id)), Reservation.class)
            .flatMap(deleteResult -> Mono.just(deleteResult.wasAcknowledged()));
    }
}
