package com.pokeCalc.chi_yu.Services;
import com.pokeCalc.chi_yu.DTOs.Request.AbilityRequestDto;
import com.pokeCalc.chi_yu.DTOs.Response.AbilityResponseDto;

import java.util.UUID;

public interface AbilityService {
    public AbilityResponseDto createAbility(AbilityRequestDto dto);
    public AbilityResponseDto getAbility(UUID abilityId);
    public AbilityResponseDto updateAbility(UUID abilityId, AbilityRequestDto dto);

    }