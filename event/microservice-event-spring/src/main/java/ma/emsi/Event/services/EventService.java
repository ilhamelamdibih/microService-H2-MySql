package ma.emsi.Event.services;

import ma.emsi.Event.entities.Event;
import ma.emsi.Event.entities.User;
import ma.emsi.Event.models.EventResponse;
import ma.emsi.Event.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private RestTemplate restTemplate;

    private final String URL = "http://localhost:8888/SERVICE-USER"; // Update with the appropriate user service URL

    public List<EventResponse> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream()
                .map(this::mapToEventResponse)
                .toList();
    }

    public EventResponse getEventById(Long eventId) throws Exception {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new Exception("Invalid Event Id"));
        return mapToEventResponse(event);
    }

    public EventResponse createEvent(EventResponse eventResponse) {
        Event event = mapToEventEntity(eventResponse);
        Event savedEvent = eventRepository.save(event);
        return mapToEventResponse(savedEvent);
    }

    public void deleteEvent(Long eventId) {
        eventRepository.deleteById(eventId);
    }

    private EventResponse mapToEventResponse(Event event) {
        // Assume you have a method to get a User by userId
        User organizer = new User();
        organizer.setId(1L);
        organizer.setUsername("Organizer");

        return EventResponse.builder()
                .id(event.getId())
                .eventName(event.getEventName())
                .venue(event.getVenue())
                .dateAndTime(event.getDateAndTime())
                .description(event.getDescription())
                .organizer(organizer)
                .ticketPrice(event.getTicketPrice())
                .quantity(event.getQuantity())
                .image(event.getImage())
                .category(event.getCategory())
                .isPublished(event.getIsPublished())
                .build();
    }

    private Event mapToEventEntity(EventResponse eventResponse) {
        Event event = new Event();
        event.setEventName(eventResponse.getEventName());
        event.setVenue(eventResponse.getVenue());
        event.setDateAndTime(eventResponse.getDateAndTime());
        event.setDescription(eventResponse.getDescription());
        event.setOrganizerId(eventResponse.getOrganizer().getId());
        event.setTicketPrice(eventResponse.getTicketPrice());
        event.setQuantity(eventResponse.getQuantity());
        event.setCategory(eventResponse.getCategory());
        event.setImage(eventResponse.getImage());
        event.setIsPublished(eventResponse.getIsPublished());
        return event;
    }
}