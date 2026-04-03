package com.pokeCalc.chi_yu.DTOs.Response;

import java.util.UUID;

public record PokeSpecieSummaryDto (UUID id,
                                    int nationalDexNumber,
                                    String pokemonName) {
}
