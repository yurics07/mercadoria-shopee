package com.mercadoria.shopee.Service;

import com.mercadoria.shopee.Dto.MercadoriaCreateDTO;
import com.mercadoria.shopee.Entity.Mercadoria;
import com.mercadoria.shopee.Repository.MercadoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MercadoriaService {
    @Autowired
    private MercadoriaRepository mercadoriaRepository;

    public MercadoriaCreateDTO findById(UUID id){
        Mercadoria mercadoria = mercadoriaRepository.findById(id).orElseThrow();

        MercadoriaCreateDTO mercadoriaCreateDTO = convertToDto(mercadoria);
        return mercadoriaCreateDTO;
    }
    public MercadoriaCreateDTO save(MercadoriaCreateDTO mercadoriaDto){
        Mercadoria mercadoria = convertToEntity(mercadoriaDto);
        mercadoria = mercadoriaRepository.save(mercadoria);
        return convertToDto(mercadoria);
    }
    public MercadoriaCreateDTO update(UUID id, MercadoriaCreateDTO mercadoriaDto){
        Mercadoria mercadoria = convertToEntity(mercadoriaDto);
        mercadoria.setId(id);
        mercadoria = mercadoriaRepository.save(mercadoria);
        return convertToDto(mercadoria);
    }
    public void deleteById(UUID id){mercadoriaRepository.deleteById(id);}

    public List<MercadoriaCreateDTO> findAll() {
        List<Mercadoria> mercadoria = mercadoriaRepository.findAll();
        List<MercadoriaCreateDTO> mercadoriaDto = new ArrayList<>();
        for (Mercadoria mercadoria1 : mercadoria) {
            mercadoriaDto.add(convertToDto(mercadoria1));
        }
        return mercadoriaDto;
    }

    public MercadoriaCreateDTO convertToDto(Mercadoria mercadoria){
        MercadoriaCreateDTO mercadoriaDto = new MercadoriaCreateDTO();

        mercadoriaDto.setNome(mercadoria.getNome());
        mercadoriaDto.setPreco(mercadoria.getPreco());
        mercadoriaDto.setQuantidade(mercadoria.getQuantidade());
        mercadoriaDto.setCategoria(mercadoria.getCategoria());
        return mercadoriaDto;
    }

    public Mercadoria convertToEntity(MercadoriaCreateDTO mercadoriaCreateDTO){
        Mercadoria mercadoria = new Mercadoria();

        mercadoria.setNome(mercadoriaCreateDTO.getNome());
        mercadoria.setPreco(mercadoriaCreateDTO.getPreco());
        mercadoria.setQuantidade(mercadoriaCreateDTO.getQuantidade());
        mercadoria.setCategoria(mercadoriaCreateDTO.getCategoria());
        return mercadoria;
    }
}
