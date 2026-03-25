package com.pokeCalc.chi_yu.DTOs.Response;

import com.pokeCalc.chi_yu.Entities.Enums.AbilityType;

import java.util.UUID;

public record AbilityResponseDto (UUID id, String name, String description, AbilityType type){
}
