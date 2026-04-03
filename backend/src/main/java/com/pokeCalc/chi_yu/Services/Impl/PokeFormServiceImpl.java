package com.pokeCalc.chi_yu.Services.Impl;
import com.pokeCalc.chi_yu.DTOs.Mappers.PokeFormMapper;
import com.pokeCalc.chi_yu.DTOs.Request.PokeFormRequestDto;
import com.pokeCalc.chi_yu.DTOs.Response.PokeFormResponseDto;
import com.pokeCalc.chi_yu.Entities.PokemonForm;
import com.pokeCalc.chi_yu.Entities.PokemonSpecie;
import com.pokeCalc.chi_yu.Repositories.PokeSpecieRepository;
import com.pokeCalc.chi_yu.Repositories.PokemonFormRepository;
import com.pokeCalc.chi_yu.Services.PokeFormService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PokeFormServiceImpl implements PokeFormService {

    private final PokeSpecieRepository pokemonSpecieRepository;

    private final PokemonFormRepository pokemonFormRepository;

    private final PokeFormMapper pokeFormMapper;

    @Override
    public PokeFormResponseDto getPokeForm(UUID id) {
        PokemonForm pokemonForm = buscarPoke(id);
        return pokeFormMapper.entityToDto(pokemonForm);
    }

    @Override
    public PokeFormResponseDto createPokeForm(PokeFormRequestDto dto) {
        PokemonForm pokemonForm = pokeFormMapper.dtoToEntity(dto);
        PokemonSpecie specie = pokemonSpecieRepository.findById(dto.specieId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Não foi possível encontrar uma espécie de pokémon com o id: " + dto.specieId()));

        pokemonForm.setSpecie(specie);

        PokemonForm savedForm = pokemonFormRepository.save(pokemonForm);
        return pokeFormMapper.entityToDto(savedForm);
    }

    @Override
    public PokeFormResponseDto updatePokeForm(UUID id, PokeFormRequestDto dto) {
        PokemonForm oldPokeForm = buscarPoke(id);

        oldPokeForm.setFormName(dto.formName());


        PokemonForm updatedPokeForm = pokemonFormRepository.save(oldPokeForm);

        return pokeFormMapper.entityToDto(updatedPokeForm);
    }

    @Override
    public void deletePokeForm(UUID id) {
        PokemonForm pokemonForm = buscarPoke(id);
        pokemonFormRepository.delete(pokemonForm);
    }

    private PokemonForm buscarPoke(UUID id){
        return pokemonFormRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Não foi possível encontrar uma PokeForm com o id: " + id));
    }

}
