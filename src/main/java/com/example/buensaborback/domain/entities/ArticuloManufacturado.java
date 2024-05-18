package com.example.buensaborback.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@SuperBuilder
public class ArticuloManufacturado extends Articulo {

    private String descripcion;
    private Integer tiempoEstimadoMinutos;
    @Column(columnDefinition = "TEXT")
    private String preparacion;
    @Transient
    private Integer stock;
    @Transient
    private Double precioCosto;

    @OneToMany(mappedBy = "articuloManufacturado", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @Builder.Default
    private Set<ArticuloManufacturadoDetalle> articuloManufacturadoDetalles = new HashSet<>();

    public static double redondear(double value) {
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public Integer stockCalculado() throws RuntimeException, InterruptedException {

        // Se calculan los stocks disponibles de cada ingrediente por la cantidad que se vaya a usar de cada uno
        List<Integer> stocksPorCantidad = articuloManufacturadoDetalles.stream().map(
                detalle -> (int) (detalle.getArticuloInsumo().getStockActual() / detalle.getCantidad()
                )
        ).toList();
        articuloManufacturadoDetalles.stream().forEach(
                detalle -> System.out.println("Detalle: " + detalle.getCantidad() + " unidades de " + detalle.getArticuloInsumo().getDenominacion() + ", con stock " + detalle.getArticuloInsumo().getStockActual())
        );

        // Se busca el mínimo stock disponible
        Integer stockMinimo = stocksPorCantidad.stream().reduce(Integer.MAX_VALUE, (a, b) -> a < b ? a : b);

        // Si no hay stock, se lanza una excepción
        if (stockMinimo < 0) {
            return 0;
        } else {
            return stockMinimo;
        }
    }

    public Double precioCostoCalculado() {

        // Se calcula el costo de cada ingrediente por la cantidad que se vaya a usar de cada uno
        List<Double> costos = articuloManufacturadoDetalles.stream().map(
                detalle -> (detalle.getArticuloInsumo().getPrecioCompra() * detalle.getCantidad())
        ).toList();
        articuloManufacturadoDetalles.stream().forEach(
                detalle -> System.out.println(detalle.getCantidad() + " unidades de " + detalle.getArticuloInsumo().getDenominacion() + " con costo unitario de $" + detalle.getArticuloInsumo().getPrecioCompra() + " = " + detalle.getArticuloInsumo().getPrecioCompra() * detalle.getCantidad())
        );

        // Se suman los costos
        Double costo = redondear(costos.stream().reduce(0d, Double::sum));

        return costo;
    }
}
