package at.kaindorf.htl.event.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String description;
    private String imageUrl;
    @ManyToMany(mappedBy = "artists")
    private List<Event> events = new ArrayList<>();
}
