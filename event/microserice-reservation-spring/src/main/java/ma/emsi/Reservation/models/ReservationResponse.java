package ma.emsi.Reservation.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.emsi.Reservation.entities.Event;
import ma.emsi.Reservation.entities.User;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationResponse {
    private Long id;
    private Event event;
    private User user;
    private int numberOfSeats;

    public ReservationResponse(Event event) {
        this.event = event;
    }
}
