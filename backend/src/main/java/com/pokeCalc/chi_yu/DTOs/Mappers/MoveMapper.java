package com.pokeCalc.chi_yu.DTOs.Mappers;

import com.pokeCalc.chi_yu.DTOs.Request.MoveGenerationDataRequestDto;
import com.pokeCalc.chi_yu.DTOs.Request.MoveRequestDto;
import com.pokeCalc.chi_yu.DTOs.Response.MoveResponseDto;
import com.pokeCalc.chi_yu.Entities.Move;
import com.pokeCalc.chi_yu.Entities.MoveGenerationData;
import org.springframework.stereotype.Component;

@Component
public class MoveMapper {
    public Move dtoToEntity(MoveRequestDto dto){
        Move move = new Move();
        move.setMoveName(dto.moveName());
        return move;
    }

    public MoveResponseDto entityToDto(Move move){
        return new MoveResponseDto(move.getId(), move.getMoveName(), move.getMoveGenerationData());
    }

    public MoveGenerationData dtoGenDataToEntity(MoveGenerationDataRequestDto dto){
        MoveGenerationData genData = new MoveGenerationData();
        genData.setBaseDamage(dto.baseDamage());
        genData.setGeneration(dto.generation());
        genData.setType(dto.elementalType());
        return genData;
    }
}
