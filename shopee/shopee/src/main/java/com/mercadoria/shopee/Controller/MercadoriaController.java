package com.mercadoria.shopee.Controller;

import com.mercadoria.shopee.Dto.MercadoriaCreateDTO;
import com.mercadoria.shopee.Service.MercadoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/mercadoria")
//http://localhost:8080/api/v1/mercadoria/1

public class MercadoriaController {
    @Autowired
    MercadoriaService service;

    @GetMapping("/{id}")
    public MercadoriaCreateDTO findById(@PathVariable("id") UUID id){return service.findById(id);}

    @GetMapping
    public List<MercadoriaCreateDTO> findAll(){return service.findAll();}

    @PostMapping
    public MercadoriaCreateDTO save(
            @RequestBody MercadoriaCreateDTO mercadoriaCreateDTO){
        return service.save(mercadoriaCreateDTO);}

    @PutMapping("/{id}")
    public MercadoriaCreateDTO update(
            @PathVariable("id")UUID id,@RequestBody MercadoriaCreateDTO mercadoriaCreateDTO){
        return service.update(id,mercadoriaCreateDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id")UUID id){
        service.deleteById(id);
    }
}
