package ma.emsi.Reservation.controllers;

import ma.emsi.Reservation.ReservationApplication;
import ma.emsi.Reservation.entities.Event;
import ma.emsi.Reservation.entities.LigneReservation;
import ma.emsi.Reservation.entities.Reservation;
import ma.emsi.Reservation.models.ReservationResponse;
import ma.emsi.Reservation.models.ReservationWithEventResponse;
import ma.emsi.Reservation.services.LigneReservationService;
import ma.emsi.Reservation.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private LigneReservationService lignereservationService;


    @GetMapping
    public List<Reservation> findAll() {
        return reservationService.getAllReservations();
    }


    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        try {
            Reservation createdReservation = reservationService.createReservation(reservation);
            for(LigneReservation l :reservation.getLigneReservation())
            {
                l.setReservation(createdReservation);
                lignereservationService.createLigneReservation(l);
            }
            return new ResponseEntity<>(createdReservation, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
