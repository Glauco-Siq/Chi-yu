package com.pokeCalc.chi_yu.Services;

import com.pokeCalc.chi_yu.DTOs.Request.SpecieRequestDto;
import com.pokeCalc.chi_yu.DTOs.Response.SpecieResponseDto;

import java.util.UUID;

public interface PokeSpecieService {
    public SpecieResponseDto createSpecie(SpecieRequestDto dto);
    public SpecieResponseDto getSpecie(UUID id);
    public SpecieResponseDto updateSpecie(UUID id, SpecieRequestDto dto);
    public void deleteSpecie(UUID id);
}
