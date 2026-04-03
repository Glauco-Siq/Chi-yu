package com.pokeCalc.chi_yu.Services;
import com.pokeCalc.chi_yu.DTOs.Request.MoveGenerationDataRequestDto;
import com.pokeCalc.chi_yu.DTOs.Request.MoveRequestDto;
import com.pokeCalc.chi_yu.DTOs.Response.MoveGenerationDataResponseDto;
import com.pokeCalc.chi_yu.DTOs.Response.MoveResponseDto;
import com.pokeCalc.chi_yu.Entities.MoveGenerationData;

import java.util.UUID;

public interface MoveService {
    public MoveResponseDto createMove(MoveRequestDto moveDto);
    public MoveResponseDto getMove(UUID moveId);
    public MoveResponseDto updateMove(UUID moveId, MoveRequestDto moveRequestDto);
    public void deleteMove(UUID id);
    public MoveResponseDto addMoveGenerationData(UUID moveId, MoveGenerationDataRequestDto dto);
    public MoveGenerationDataResponseDto getMoveGenerationData(UUID id);
    public MoveGenerationDataResponseDto editMoveGenerationData(UUID moveGenDataId, MoveGenerationDataRequestDto dto);
    public MoveResponseDto deleteMoveGenerationData(UUID moveGenDataId);
}
