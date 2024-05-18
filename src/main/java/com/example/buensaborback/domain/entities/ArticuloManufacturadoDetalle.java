package com.example.buensaborback.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class ArticuloManufacturadoDetalle extends Base {
    
    private Double cantidad;
    
    @ManyToOne
    @JoinColumn(name = "articulo_insumo_id")
    private ArticuloInsumo articuloInsumo;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "articulo_manufacturado_id")
    @JsonBackReference(value = "manufacturadodetalle_manufacturado")
    private ArticuloManufacturado articuloManufacturado;

}
