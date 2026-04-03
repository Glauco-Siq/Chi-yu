package com.pokeCalc.chi_yu.DTOs.Request;

import com.pokeCalc.chi_yu.Entities.PokemonSpecie;

import java.util.UUID;

public record PokeFormRequestDto (String formName, UUID specieId) {
}
