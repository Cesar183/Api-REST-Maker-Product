package com.api.restUp.controllers;

import com.api.restUp.controllers.dto.MakerDto;
import com.api.restUp.entities.Maker;
import com.api.restUp.service.MakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "maker")
public class MakerController {

    @Autowired
    private MakerService service;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listAll()
                .stream()
                .map(maker -> MakerDto.builder()
                        .id(maker.getId())
                        .name(maker.getName())
                        .productList(maker.getProductList())
                        .build())
                .toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return service.findById(id)
                .map(maker -> ResponseEntity.status(HttpStatus.OK).body(MakerDto.builder()
                        .id(maker.getId())
                        .name(maker.getName())
                        .productList(maker.getProductList())
                        .build()))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody MakerDto makerDto){
        if (makerDto.getName().isBlank()){
            return ResponseEntity.badRequest().build();
        }
        var maker = service.save(Maker.builder()
                .name(makerDto.getName())
                .build());
        return ResponseEntity.status(HttpStatus.OK).body(maker);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody MakerDto makerDto){
        return service.findById(id)
                .map(maker -> {
                    maker.setName(makerDto.getName());
                    return ResponseEntity.status(HttpStatus.CREATED).body(service.save(maker));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return service.findById(id)
                .map(maker -> {
                    service.delete(id);
                    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
