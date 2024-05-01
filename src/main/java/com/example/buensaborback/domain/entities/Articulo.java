package com.example.buensaborback.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.HashSet;
import java.util.Set;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@SuperBuilder
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Articulo extends Base{

    protected String denominacion;
    protected Double precioVenta;

    @OneToMany(mappedBy = "articulo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    protected Set<Imagen> imagenes = new HashSet<>();

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "UnidadMedida_ID")
    protected UnidadMedida unidadMedida;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "Categoria_ID")
    protected Categoria categoria;

    @OneToMany(mappedBy = "articulo")
    @Builder.Default
    protected Set<DetallePedido> detallePedidos = new HashSet<>();

    @ManyToMany(mappedBy = "articulos", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @Builder.Default
    protected Set<Promocion> estaEnPromociones = new HashSet<>();

}
