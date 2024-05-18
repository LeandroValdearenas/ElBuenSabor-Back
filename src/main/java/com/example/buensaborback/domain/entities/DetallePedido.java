package com.example.buensaborback.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class DetallePedido extends Base{

    private Integer cantidad;
    private Double subTotal;

    @ManyToOne
    @JoinColumn(name = "articulo_id")
    @JsonIgnoreProperties({"imagenes", "unidadMedida", "categoria", "articuloManufacturadoDetalles"})
    private Articulo articulo;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "pedido_id")
    @JsonBackReference(value = "detallepedido_pedido")
    private Pedido pedido;
}
