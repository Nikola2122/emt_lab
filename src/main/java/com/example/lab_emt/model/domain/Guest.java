package com.example.lab_emt.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "guests")
public class Guest extends BaseAuditableEntity {
    String name;
    String surname;

    @ManyToMany
    @JoinTable(
            name = "guests_hosts",
            joinColumns = @JoinColumn(name="guest_id"),
            inverseJoinColumns = @JoinColumn(name = "host_id")
    )
    private List<Host> hosts = new ArrayList<>();

    public Guest(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
