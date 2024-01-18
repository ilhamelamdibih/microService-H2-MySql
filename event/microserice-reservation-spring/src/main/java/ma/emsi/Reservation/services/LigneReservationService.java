package ma.emsi.Reservation.services;

import ma.emsi.Reservation.entities.Event;
import ma.emsi.Reservation.entities.LigneReservation;
import ma.emsi.Reservation.entities.Reservation;
import ma.emsi.Reservation.entities.User;
import ma.emsi.Reservation.models.ReservationResponse;
import ma.emsi.Reservation.repositories.LigneReservationRepository;
import ma.emsi.Reservation.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class LigneReservationService {

    @Autowired
    private LigneReservationRepository lignereservationRepository;


    public List<LigneReservation> getAllLigneReservations() {
        List<LigneReservation> ligneReservations = lignereservationRepository.findAll();
        return ligneReservations;
    }


    public LigneReservation createLigneReservation(LigneReservation ligneReservation) {
        return lignereservationRepository.save(ligneReservation);

    }


}

