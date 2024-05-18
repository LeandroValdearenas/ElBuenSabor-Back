package com.example.buensaborback.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class Provincia extends Base{

    private String nombre;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pais_id")
    private Pais pais;

    @OneToMany(mappedBy = "provincia")
    @ToString.Exclude
    @Builder.Default
    @JsonBackReference(value = "provincia_localidades")
    private Set<Localidad> localidades = new HashSet<>();
}
