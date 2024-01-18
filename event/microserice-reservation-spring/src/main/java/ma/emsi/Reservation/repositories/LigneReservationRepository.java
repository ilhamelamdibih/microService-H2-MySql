package ma.emsi.Reservation.repositories;

import ma.emsi.Reservation.entities.LigneReservation;
import ma.emsi.Reservation.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneReservationRepository extends JpaRepository<LigneReservation,Long> {
}
