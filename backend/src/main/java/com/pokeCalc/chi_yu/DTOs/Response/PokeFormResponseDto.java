package com.pokeCalc.chi_yu.DTOs.Response;

import com.pokeCalc.chi_yu.Entities.PokemonSpecie;
import com.pokeCalc.chi_yu.Entities.PokemonStatHistory;

import java.util.List;
import java.util.UUID;

public record PokeFormResponseDto (UUID id, String formName, PokeSpecieSummaryDto specieSummaryDto, List<PokemonStatHistory> statHistory) {
}
