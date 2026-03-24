package com.pokeCalc.chi_yu.DTOs.Response;

import com.pokeCalc.chi_yu.Entities.Enums.Generation;
import com.pokeCalc.chi_yu.Entities.Enums.MoveType;
import com.pokeCalc.chi_yu.Entities.Enums.Type;

import java.util.UUID;

public record MoveGenerationDataResponseDto (UUID id, UUID moveId, Integer baseDamage,
                                             MoveType moveType, Generation generation,
                                             Type type){}
