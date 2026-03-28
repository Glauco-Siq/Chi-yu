package com.pokeCalc.chi_yu.DTOs.Response;

import com.pokeCalc.chi_yu.Entities.PokemonForm;

import java.util.List;
import java.util.UUID;

public record SpecieResponseDto (UUID id, int nationalDexNumber, String pokemonName, List<PokemonForm> pokemonFormList) {
}
