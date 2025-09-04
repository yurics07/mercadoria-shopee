package com.mercadoria.shopee.Service;

import com.mercadoria.shopee.Dto.FornecedorCreateDTO;
import com.mercadoria.shopee.Entity.Fornecedor;
import com.mercadoria.shopee.Repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FornecedorService {
    @Autowired
    FornecedorRepository repository;

    public FornecedorCreateDTO findById(UUID id){
        Fornecedor fornecedor = repository.findById(id).orElseThrow();
        FornecedorCreateDTO fornecedorDto = convertToDto(fornecedor);
        return fornecedorDto;
    }
    public FornecedorCreateDTO save(FornecedorCreateDTO fornecedorDto){
        Fornecedor fornecedor = convertToEntity(fornecedorDto);
        fornecedor = repository.save(fornecedor);
        return convertToDto(fornecedor);
    }
    public FornecedorCreateDTO update(UUID id, FornecedorCreateDTO fornecedorDto){
        Fornecedor fornecedor = convertToEntity(fornecedorDto);
        fornecedor.setId(id);
        fornecedor = repository.save(fornecedor);
        return convertToDto(fornecedor);
    }
    public void deleteById(UUID id){repository.deleteById(id);}

    public List<FornecedorCreateDTO> findAll(){
        List<Fornecedor> fornecedores = repository.findAll();
        List<FornecedorCreateDTO> fornecedorDtos = new ArrayList<>();
        for (Fornecedor fornecedor : fornecedores) {
            fornecedorDtos.add(convertToDto(fornecedor));
        }
        return fornecedorDtos;
    }
    public FornecedorCreateDTO convertToDto(Fornecedor fornecedor){
        FornecedorCreateDTO fornecedorDto = new FornecedorCreateDTO();

        fornecedorDto.setNome(fornecedorDto.getNome());
        fornecedorDto.setContato(fornecedorDto.getContato());
        fornecedorDto.setEndereco(fornecedorDto.getEndereco());
        return fornecedorDto;
    }
    public Fornecedor convertToEntity(FornecedorCreateDTO fornecedorDto){
        Fornecedor fornecedor = new Fornecedor();

        fornecedorDto.setNome(fornecedorDto.getNome());
        fornecedorDto.setContato(fornecedorDto.getContato());
        fornecedorDto.setEndereco(fornecedorDto.getEndereco());
        return fornecedor;
    }
}
