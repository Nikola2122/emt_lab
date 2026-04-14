package com.example.lab_emt.model.views;

import com.example.lab_emt.model.enums.Category;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

@Entity
@Getter
@Immutable
@Table(name = "accommodation_view")
public class AccommodationView {
    @Id
    private Long id;
    String name;
    @Enumerated(EnumType.STRING)
    Category category;
    Integer numRooms;
    String hostNameAndSurname;
    String countryName;
}
