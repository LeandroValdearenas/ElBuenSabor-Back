package com.example.buensaborback.controller;

import com.example.buensaborback.domain.entities.ArticuloManufacturado;
import com.example.buensaborback.domain.entities.Promocion;
import com.example.buensaborback.service.PromocionServiceImpl;
import com.example.buensaborback.service.SucursalServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "api/promociones")
public class PromocionController extends BaseControllerImpl<Promocion, PromocionServiceImpl>{

    private PromocionServiceImpl service;
    public PromocionController(PromocionServiceImpl service) {
        super(service);
        this.service = service;
    }

    @Override
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Promocion promocion){
        try {
            promocion.getImagenes().forEach(imagen -> imagen.setPromocion(promocion));
            promocion.getPromocionDetalles().forEach(detalle -> detalle.setPromocion(promocion));
            service.save(promocion);
            return ResponseEntity.status(HttpStatus.OK).body(service.save(promocion));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente luego\"}");
        }
    }

    @Override
    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Promocion promocion){
        try {
            promocion.getImagenes().forEach(imagen -> imagen.setPromocion(promocion));
            promocion.getPromocionDetalles().forEach(detalle -> detalle.setPromocion(promocion));
            Promocion searchedEntity = service.findById(id);
            if (searchedEntity == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. No se encontro la entidad\"}");
            }
            return ResponseEntity.status(HttpStatus.OK).body(service.update(promocion));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente luego\"}");
        }
    }
}

