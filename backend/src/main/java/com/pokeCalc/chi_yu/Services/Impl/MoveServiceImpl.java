package com.pokeCalc.chi_yu.Services.Impl;
import com.pokeCalc.chi_yu.DTOs.Mappers.MoveMapper;
import com.pokeCalc.chi_yu.DTOs.Request.MoveGenerationDataRequestDto;
import com.pokeCalc.chi_yu.DTOs.Request.MoveRequestDto;
import com.pokeCalc.chi_yu.DTOs.Response.MoveResponseDto;
import com.pokeCalc.chi_yu.Entities.Move;
import com.pokeCalc.chi_yu.Entities.MoveGenerationData;
import com.pokeCalc.chi_yu.Repositories.MoveRepository;
import com.pokeCalc.chi_yu.Services.MoveService;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class MoveServiceImpl implements MoveService {

    @Autowired
    MoveMapper moveMapper;

    @Autowired
    MoveRepository moveRepository;

    @Override
    public MoveResponseDto createMove(MoveRequestDto moveDto) {
        Move entity = moveMapper.dtoToEntity(moveDto);
        Move savedEntity = moveRepository.save(entity);
        return moveMapper.entityToDto(savedEntity);
    }

    @Override
    public MoveResponseDto getMove(UUID moveId) {
        return moveMapper.entityToDto(moveRepository.findById(moveId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Ataque não encontrado com o id: " + moveId)));
    }

    @Override
    public MoveResponseDto updateMove(UUID moveId, MoveRequestDto moveRequestDto) {
        Move existingMove = moveRepository.findById(moveId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        existingMove.setMoveName(moveRequestDto.moveName());
        Move updatedMove = moveRepository.save(existingMove);
        return moveMapper.entityToDto(updatedMove);
    }

    //ADD LOGICA DE GARANTIR APENAS UMA REGRA PARA CADA GERACAO
    @Override
    public MoveResponseDto addMoveGenerationData(UUID moveId, MoveGenerationDataRequestDto dto) {
        Move move = moveRepository.findById(moveId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Move não encontrado com o id: " + moveId));
        MoveGenerationData newGenData = moveMapper.dtoGenDataToEntity(dto);
        newGenData.setMove(move);

        if(move.getMoveGenerationData() == null){
            move.setMoveGenerationData(new ArrayList<>());
        }
        move.getMoveGenerationData().add(newGenData);

        Move savedMove = moveRepository.save(move);

        return moveMapper.entityToDto(savedMove);
    }

}
