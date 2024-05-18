package com.example.buensaborback.controller;

import com.example.buensaborback.domain.entities.ArticuloInsumo;
import com.example.buensaborback.service.ArticuloInsumoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "api/insumos")
public class ArticuloInsumoController extends BaseControllerImpl<ArticuloInsumo, ArticuloInsumoServiceImpl>{
    protected final ArticuloInsumoServiceImpl service;
    public ArticuloInsumoController(ArticuloInsumoServiceImpl service) {
        super(service);
        this.service = service;
    }

    @Override
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody ArticuloInsumo insumo){
        try {
            insumo.getImagenes().forEach(imagen -> imagen.setArticulo(insumo));
            return ResponseEntity.status(HttpStatus.OK).body(service.save(insumo));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente luego\"}");
        }
    }

    @Override
    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody ArticuloInsumo insumo){
        try {
            insumo.getImagenes().forEach(imagen -> imagen.setArticulo(insumo));
            ArticuloInsumo searchedEntity = service.findById(id);
            if (searchedEntity == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. No se encontro la entidad\"}");
            }
            return ResponseEntity.status(HttpStatus.OK).body(service.update(insumo));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente luego\"}");
        }
    }
}

