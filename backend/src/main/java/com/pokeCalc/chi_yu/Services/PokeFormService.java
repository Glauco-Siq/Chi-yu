package com.pokeCalc.chi_yu.Services;
import com.pokeCalc.chi_yu.DTOs.Request.PokeFormRequestDto;
import com.pokeCalc.chi_yu.DTOs.Response.PokeFormResponseDto;

import java.util.UUID;

public interface PokeFormService {
    public PokeFormResponseDto getPokeForm (UUID id);
    public PokeFormResponseDto createPokeForm (PokeFormRequestDto dto);
    public PokeFormResponseDto updatePokeForm (UUID id, PokeFormRequestDto dto);
    public void deletePokeForm (UUID id);
}
