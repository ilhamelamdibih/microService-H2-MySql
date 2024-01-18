package ma.emsi.Event.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.emsi.Event.entities.User;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventResponse {
    private Long id;
    private String eventName;
    private String venue; // lieu de l'événement
    private LocalDateTime dateAndTime; // date et heure de l'événement
    private String description; // description de l'événement
    private User organizer; // organisateur de l'événement
    private Double ticketPrice; // prix du billet
    private int quantity;
    private String category;

    private String image;// nombre de sièges disponibles
    private Boolean isPublished;
}
