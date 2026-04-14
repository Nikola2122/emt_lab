package com.example.lab_emt.model.views;

import com.example.lab_emt.model.enums.Category;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

import java.math.BigDecimal;

@Entity
@Getter
@Immutable
@Table(name = "accommodation_mat_view")
public class AccMatView {

    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    private Category category;

    private Long totalAccommodations;

    private Integer totalRooms;

    private BigDecimal avgRooms;
}