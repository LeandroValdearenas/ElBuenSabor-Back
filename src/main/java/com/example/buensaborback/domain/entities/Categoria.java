package com.example.buensaborback.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class Categoria extends Base{

    private String denominacion;

    @OneToMany(mappedBy = "categoriaPadre", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private Set<Categoria> subCategorias = new HashSet<>();

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "categoria_padre_id")
    @JsonBackReference(value = "categoria_categoriaPadre")
    private Categoria categoriaPadre;

    @ManyToMany(mappedBy = "categorias")
    @ToString.Exclude
    @Builder.Default
    @JsonIgnoreProperties({"nombre", "domicilio"})
    private Set<Sucursal> sucursales = new HashSet<>();

    @OneToMany(mappedBy = "categoria")
    @ToString.Exclude
    @Builder.Default
    @JsonBackReference(value = "categoria_articulos")
    private Set<Articulo> articulos = new HashSet<>();
}
