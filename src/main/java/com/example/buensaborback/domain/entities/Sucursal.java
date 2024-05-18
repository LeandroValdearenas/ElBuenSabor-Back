package com.example.buensaborback.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class Sucursal extends Base{

    private String nombre;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private Boolean casaMatriz;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "domicilio_id")
    private Domicilio domicilio;
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinTable(name = "sucursal_categoria",
            joinColumns = @JoinColumn(name = "sucursal_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    @Builder.Default
    @JsonBackReference(value = "sucursal_categorias")
    private Set<Categoria> categorias = new HashSet<>();

    @OneToMany(mappedBy = "sucursal", fetch = FetchType.LAZY)
    @ToString.Exclude
    @Builder.Default
    @JsonBackReference(value = "sucursal_pedidos")
    private Set<Pedido> pedidos = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "sucursal_promocion",
            joinColumns = @JoinColumn(name = "sucursal_id"),
            inverseJoinColumns = @JoinColumn(name = "promocion_id"))
    @JsonIgnoreProperties({"denominacion", "fechaDesde", "fechaHasta", "sucursales"})
    private Set<Promocion> promociones = new HashSet<>();

    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @ToString.Exclude
    @Builder.Default
    @JsonBackReference(value = "sucursal_empleados")
    private Set<Empleado> empleados = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    @JsonIgnoreProperties("sucursales")
    private Empresa empresa;
}
