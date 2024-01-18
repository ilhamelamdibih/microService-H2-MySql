package ma.emsi.Reservation.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    private Long id;
    private String eventName;
    private String venue; // lieu de l'événement
    private LocalDateTime dateAndTime; // date et heure de l'événement
    private String description; // description de l'événement
    private User organizer; // organisateur de l'événement
    private Double ticketPrice; // prix du billet
    private int availableSeats; // nombre de sièges disponibles
    private Boolean isPublished;

    private String category;
    private String image;
}
