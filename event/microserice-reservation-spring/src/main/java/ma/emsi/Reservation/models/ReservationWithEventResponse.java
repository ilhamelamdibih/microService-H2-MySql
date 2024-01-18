package ma.emsi.Reservation.models;

import lombok.*;
import ma.emsi.Reservation.entities.Event;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ReservationWithEventResponse {
    private ReservationResponse reservation;
    private Event event;
}
