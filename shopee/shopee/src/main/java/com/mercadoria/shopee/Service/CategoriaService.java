package com.mercadoria.shopee.Service;

import com.mercadoria.shopee.Dto.CategoriaCreateDTO;
import com.mercadoria.shopee.Entity.Categoria;
import com.mercadoria.shopee.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository repository;

    public CategoriaCreateDTO findById(UUID id){
        Categoria categoria = repository.findById(id).orElseThrow();
        CategoriaCreateDTO categoriaDto = convertToDto(categoria);
        return categoriaDto;
    }
    public CategoriaCreateDTO save(CategoriaCreateDTO categoriaDto){
        Categoria categoria = convertToEntity(categoriaDto);
        categoria = repository.save(categoria);
        return convertToDto(categoria);
    }
    public CategoriaCreateDTO update(UUID id, CategoriaCreateDTO categoriaDto){
        Categoria categoria = convertToEntity(categoriaDto);
        categoria = repository.save(categoria);
        return convertToDto(categoria);
    }
    public void deleteById(UUID id){repository.deleteById(id);}

    public List<CategoriaCreateDTO> findAll(){
        List<Categoria> categorias = repository.findAll();
        List<CategoriaCreateDTO> categoriasDtos = new ArrayList<>();
        for (Categoria categoria : categorias) {
            categoriasDtos.add(convertToDto(categoria));
        }
        return categoriasDtos;
    }
    public CategoriaCreateDTO convertToDto(Categoria categoria){
        CategoriaCreateDTO categoriaDto = new CategoriaCreateDTO();

        categoriaDto.setNome(categoria.getNome());
        categoriaDto.setDescricao(categoria.getDescricao());
        return categoriaDto;
    }
    public Categoria convertToEntity(CategoriaCreateDTO categoriaDto){
        Categoria categoria = new Categoria();

        categoria.setNome(categoriaDto.getNome());
        categoria.setDescricao(categoriaDto.getDescricao());
        return categoria;
    }
}
