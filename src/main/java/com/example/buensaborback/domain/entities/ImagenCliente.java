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
public class ImagenCliente extends Base{

    private String url;

    @OneToOne(mappedBy = "imagen", fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonBackReference(value = "imagen_cliente")
    private Cliente cliente;

}
