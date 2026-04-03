package com.pokeCalc.chi_yu.DTOs.Mappers;
import com.pokeCalc.chi_yu.DTOs.Request.PokeFormRequestDto;
import com.pokeCalc.chi_yu.DTOs.Response.PokeFormResponseDto;
import com.pokeCalc.chi_yu.DTOs.Response.PokeSpecieSummaryDto;
import com.pokeCalc.chi_yu.Entities.PokemonForm;
import org.springframework.stereotype.Component;

@Component
public class PokeFormMapper {

    public PokemonForm dtoToEntity (PokeFormRequestDto dto){
        PokemonForm pokemonForm = new PokemonForm();
        pokemonForm.setFormName(dto.formName());
        return pokemonForm;
    }

    public PokeFormResponseDto entityToDto (PokemonForm pokemonForm){
        PokeSpecieSummaryDto specieSummary = null;

        if(pokemonForm.getSpecie() != null){
            specieSummary = new PokeSpecieSummaryDto(
                    pokemonForm.getSpecie().getId(),
                    pokemonForm.getSpecie().getNationalDexNumber(),
                    pokemonForm.getSpecie().getPokemonName());
        }

        return new PokeFormResponseDto(pokemonForm.getId(),
                pokemonForm.getFormName(), specieSummary, pokemonForm.getPokemonStatHistory());
    }
}
