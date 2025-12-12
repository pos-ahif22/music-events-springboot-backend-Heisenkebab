package at.kaindorf.htl.event.config;


import at.kaindorf.htl.event.entity.Artist;
import at.kaindorf.htl.event.entity.Event;
import at.kaindorf.htl.event.entity.Rating;
import at.kaindorf.htl.event.repository.ArtistRepository;
import at.kaindorf.htl.event.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Component
public class DataSeeder implements CommandLineRunner {

    private final ObjectMapper objectMapper = new ObjectMapper();
    // private final ArtistRepository artistRepository;
    // private final EventRepository eventRepository;

    @Override
    public void run(String... args) throws Exception {
        InputStream inputStream = new ClassPathResource("data/music-data-2024.json").getInputStream();
        JsonDataWrapper jsonDataWrapper = objectMapper.readValue(inputStream, JsonDataWrapper.class);
        System.out.println(jsonDataWrapper);
    }

    // to-do
    record JsonDataWrapper(List<ArtistDto> artists,
                           List<EventDto> events) {
    }

    // to-do
    record ArtistDto(
            long artistId,
            String firstname,
            String lastname,
            String description,
            String imageUrl
    ) {
    }

    // to-do
    record EventDto(
            long eventId,
            String title,
            String description,
            String location,
            LocalDateTime begin,
            LocalDateTime end,
            String imageUrl,
            String artistIds,
            List<RatingDto> ratings
    ) {
    }

    // to-do
    record RatingDto(
            long ratingId,
            int stars,
            String comment
    ) {
    }

}