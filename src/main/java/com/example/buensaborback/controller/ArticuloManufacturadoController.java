package com.example.buensaborback.controller;

import com.example.buensaborback.domain.entities.ArticuloManufacturado;
import com.example.buensaborback.service.ArticuloManufacturadoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "api/manufacturados")
public class ArticuloManufacturadoController extends BaseControllerImpl<ArticuloManufacturado, ArticuloManufacturadoServiceImpl>{

    protected final ArticuloManufacturadoServiceImpl service;
    public ArticuloManufacturadoController(ArticuloManufacturadoServiceImpl service ) {
        super(service);
        this.service = service;
    }

    @Override
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody ArticuloManufacturado manufacturado){
        try {
            manufacturado.getImagenes().forEach(imagen -> imagen.setArticulo(manufacturado));
            manufacturado.getArticuloManufacturadoDetalles().forEach(detalle -> detalle.setArticuloManufacturado(manufacturado));
            return ResponseEntity.status(HttpStatus.OK).body(service.save(manufacturado));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente luego\"}");
        }
    }

    @Override
    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody ArticuloManufacturado manufacturado){
        try {
            manufacturado.getImagenes().forEach(imagen -> imagen.setArticulo(manufacturado));
            manufacturado.getArticuloManufacturadoDetalles().forEach(detalle -> detalle.setArticuloManufacturado(manufacturado));
            ArticuloManufacturado searchedEntity = service.findById(id);
            if (searchedEntity == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. No se encontro la entidad\"}");
            }
            return ResponseEntity.status(HttpStatus.OK).body(service.update(manufacturado));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente luego\"}");
        }
    }

    @Override
    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try {
            List<ArticuloManufacturado> articulosManufacturados = service.findAll();
            for (ArticuloManufacturado articulo : articulosManufacturados) {
                articulo.setPrecioCosto(articulo.precioCostoCalculado());
                articulo.setStock(articulo.stockCalculado());
            }

            return ResponseEntity.status(HttpStatus.OK).body(articulosManufacturados);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente luego\"}");
        }
    }

    @Override
    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        try {
            ArticuloManufacturado articuloManufacturado = service.findById(id);
            articuloManufacturado.setPrecioCosto(articuloManufacturado.precioCostoCalculado());
            articuloManufacturado.setStock(articuloManufacturado.stockCalculado());

            return ResponseEntity.status(HttpStatus.OK).body(articuloManufacturado);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente luego\"}");
        }
    }
}

