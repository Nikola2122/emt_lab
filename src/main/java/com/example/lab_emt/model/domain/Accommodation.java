package com.example.lab_emt.model.domain;
import com.example.lab_emt.model.enums.Category;
import com.example.lab_emt.model.enums.State;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "accommodations")
@NamedEntityGraph(
        name = "accommodation-entity-graph",
        attributeNodes = {
                @NamedAttributeNode(value = "host", subgraph = "host-subgraph"),
        },
        subgraphs = {
                @NamedSubgraph(
                        name = "host-subgraph",
                        attributeNodes = {
                                @NamedAttributeNode("country")
                        }
                )
        }
)
public class Accommodation extends BaseAuditableEntity{

    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "host_id")
    private Host host;

    @Enumerated(EnumType.STRING)
    private State state;

    private Integer numRooms;

    private Boolean booked = false;

    public Accommodation(String name, Category category, Host host, State state, Integer numRooms, Boolean booked) {
        this.name = name;
        this.category = category;
        this.host = host;
        this.state = state;
        this.numRooms = numRooms;
        this.booked = booked;

    }
}
