package com.example.buensaborback.domain.entities;

import com.example.buensaborback.domain.enums.Rol;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@SuperBuilder
public class Empleado extends Base {

    private Rol rol;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @ToString.Exclude
    @Builder.Default
    @JsonBackReference(value = "empleado_pedidos")
    private Set<Pedido> pedidos = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "domicilio_id")
    private Domicilio domicilio;

    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private LocalDate fechaNacimiento;

    @OneToOne
    @ToString.Exclude
    @JoinColumn(name = "usuario_id")
    @JsonBackReference(value = "empleado_usuario")
    private UsuarioEmpleado usuario;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "imagen_id")
    private ImagenEmpleado imagen;

    @ManyToOne
    @JoinColumn(name = "sucursal_id")
    private Sucursal sucursal;


}
