package com.example.buensaborback.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class UsuarioCliente extends Base{

    private String auth0Id;
    private String username;

    @OneToOne(mappedBy = "usuario", fetch = FetchType.LAZY)
    private Cliente cliente;
}
