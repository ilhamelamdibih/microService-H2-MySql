package ma.emsi.Reservation.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy="reservation")
    private List<LigneReservation> ligneReservation;
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<LigneReservation> getLigneReservation() {
        return ligneReservation;
    }

    public void setLigneReservation(List<LigneReservation> ligneReservation) {
        this.ligneReservation = ligneReservation;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
