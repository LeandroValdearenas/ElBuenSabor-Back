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
public class Domicilio extends Base{

    private String calle;
    private Integer numero;
    private Integer cp;

    @ManyToOne
    @JoinColumn(name = "localidad_id")
    private Localidad localidad;

    @ManyToMany(mappedBy = "domicilios", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @ToString.Exclude
    @Builder.Default
    @JsonBackReference(value = "domicilio_clientes")
    private Set<Cliente> clientes = new HashSet<>();

    @OneToMany(mappedBy = "domicilio", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @ToString.Exclude
    @Builder.Default
    @JsonBackReference(value = "domicilio_empleados")
    private Set<Empleado> empleados = new HashSet<>();

    @OneToOne(mappedBy = "domicilio")
    @ToString.Exclude
    @JsonBackReference(value = "domicilio_sucursal")
    private Sucursal sucursal;

    @OneToMany(mappedBy = "domicilio", fetch = FetchType.LAZY)
    @ToString.Exclude
    @Builder.Default
    @JsonBackReference(value = "domicilio_pedidos")
    private Set<Pedido> pedidos = new HashSet<>();
}
