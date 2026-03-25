package com.pokeCalc.chi_yu.DTOs.Request;

import com.pokeCalc.chi_yu.Entities.Enums.AbilityType;

public record AbilityRequestDto (String name, String description, AbilityType abilityType){}
