package com.example.buensaborback.domain.entities;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
public class UnidadMedida extends Base{

    private String denominacion;

    @OneToMany(mappedBy = "unidadMedida")
    @ToString.Exclude
    @Builder.Default
    @JsonBackReference(value = "unidadmedida_articulos")
    private Set<Articulo> articulos = new HashSet<>();
}
