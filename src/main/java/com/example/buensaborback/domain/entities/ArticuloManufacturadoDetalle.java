package com.example.buensaborback.domain.entities;

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
    
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "articulo_insumo_id")
    private ArticuloInsumo articuloInsumo;

}
