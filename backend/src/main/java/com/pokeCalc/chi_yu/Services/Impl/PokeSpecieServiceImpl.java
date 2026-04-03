package com.pokeCalc.chi_yu.Services.Impl;
import com.pokeCalc.chi_yu.DTOs.Mappers.PokeSpecieMapper;
import com.pokeCalc.chi_yu.DTOs.Request.SpecieRequestDto;
import com.pokeCalc.chi_yu.DTOs.Response.SpecieResponseDto;
import com.pokeCalc.chi_yu.Entities.PokemonSpecie;
import com.pokeCalc.chi_yu.Repositories.PokeSpecieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PokeSpecieServiceImpl implements com.pokeCalc.chi_yu.Services.PokeSpecieService {

    private final PokeSpecieMapper pokeSpecieMapper;

    private final PokeSpecieRepository pokeSpecieRepository;

    @Override
    public SpecieResponseDto createSpecie(SpecieRequestDto dto) {
        PokemonSpecie entity = pokeSpecieMapper.dtoToEntity(dto);
        pokeSpecieRepository.save(entity);
        return pokeSpecieMapper.entityToDto(entity);
    }

    @Override
    public SpecieResponseDto getSpecie(UUID id) {
        PokemonSpecie entity = buscarEspecie(id);

        return pokeSpecieMapper.entityToDto(entity);
    }

    @Override
    public SpecieResponseDto updateSpecie(UUID id, SpecieRequestDto dto) {
        PokemonSpecie originalSpecie = buscarEspecie(id);

        originalSpecie.setPokemonName(dto.pokemonName());
        originalSpecie.setNationalDexNumber(dto.nationalDexNumber());
        pokeSpecieRepository.save(originalSpecie);
        return pokeSpecieMapper.entityToDto(originalSpecie);
    }

    @Override
    public void deleteSpecie(UUID id) {
        PokemonSpecie specieToDelete = buscarEspecie(id);
        pokeSpecieRepository.delete(specieToDelete);
    }

    private PokemonSpecie buscarEspecie(UUID id){
        return pokeSpecieRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "A espécie de pokemon com o id "
                        + id
                        +" não foi encontrado") {
                });
    }

}
