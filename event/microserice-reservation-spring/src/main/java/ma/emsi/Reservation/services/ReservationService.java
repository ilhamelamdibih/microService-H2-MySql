package ma.emsi.Reservation.services;

import ma.emsi.Reservation.entities.Event;
import ma.emsi.Reservation.entities.Reservation;
import ma.emsi.Reservation.entities.User;
import ma.emsi.Reservation.models.ReservationResponse;
import ma.emsi.Reservation.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.Console;
import java.util.Arrays;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;



    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
       return reservations;
    }

    public Reservation createReservation(Reservation reservation) {

        return reservationRepository.save(reservation);
    }

}

