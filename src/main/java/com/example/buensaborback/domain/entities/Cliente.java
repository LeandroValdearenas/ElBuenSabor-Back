package com.example.buensaborback.domain.entities;

import com.example.buensaborback.domain.enums.Rol;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class Cliente extends Base {

    private Rol rol;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private LocalDate fechaNacimiento;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @Builder.Default
    @JsonIgnoreProperties("cliente")
    private Set<Pedido> pedidos = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "Cliente_domicilio",
            joinColumns = @JoinColumn(name = "Cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "domicilio_id"))
    @Builder.Default
    private Set<Domicilio> domicilios = new HashSet<>();

    @OneToOne
    @ToString.Exclude
    @JoinColumn(name = "usuario_id")
    @JsonBackReference(value = "cliente_usuario")
    private UsuarioCliente usuario;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "imagen_id")
    private ImagenCliente imagen;
}
