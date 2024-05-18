package com.example.buensaborback.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class ImagenEmpresa extends Base{

    private String url;

    @OneToOne(mappedBy = "imagen", fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonBackReference(value = "imagen_empresa")
    private Empresa empresa;
    
}
