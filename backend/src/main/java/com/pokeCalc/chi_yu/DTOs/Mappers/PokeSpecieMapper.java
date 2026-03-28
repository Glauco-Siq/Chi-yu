package com.pokeCalc.chi_yu.DTOs.Mappers;
import com.pokeCalc.chi_yu.DTOs.Request.SpecieRequestDto;
import com.pokeCalc.chi_yu.DTOs.Response.SpecieResponseDto;
import com.pokeCalc.chi_yu.Entities.PokemonSpecie;
import org.springframework.stereotype.Component;

@Component
public class PokeSpecieMapper {
    public PokemonSpecie dtoToEntity (SpecieRequestDto dto){
        PokemonSpecie specie = new PokemonSpecie();
        specie.setPokemonName(dto.pokemonName());
        specie.setNationalDexNumber(dto.nationalDexNumber());

        return specie;
    }

    public SpecieResponseDto entityToDto (PokemonSpecie specie){
        SpecieResponseDto dto = new SpecieResponseDto(specie.getId(), specie.getNationalDexNumber(), specie.getPokemonName(), specie.getForms());
        return dto;
    }


}
