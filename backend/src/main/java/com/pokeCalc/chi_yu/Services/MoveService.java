package com.pokeCalc.chi_yu.Services;
import com.pokeCalc.chi_yu.DTOs.Request.MoveGenerationDataRequestDto;
import com.pokeCalc.chi_yu.DTOs.Request.MoveRequestDto;
import com.pokeCalc.chi_yu.DTOs.Response.MoveGenerationDataResponseDto;
import com.pokeCalc.chi_yu.DTOs.Response.MoveResponseDto;
import java.util.UUID;

public interface MoveService {
    public MoveResponseDto createMove(MoveRequestDto moveDto);
    public MoveResponseDto getMove(UUID moveId);
    public MoveResponseDto updateMove(UUID moveId, MoveRequestDto moveRequestDto);
    public MoveResponseDto addMoveGenerationData(UUID moveId, MoveGenerationDataRequestDto dto);
    public MoveGenerationDataResponseDto editMoveGenerationData(UUID moveGenDataId, MoveGenerationDataRequestDto dto);
}
