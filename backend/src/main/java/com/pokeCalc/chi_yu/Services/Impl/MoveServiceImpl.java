package com.pokeCalc.chi_yu.Services.Impl;
import com.pokeCalc.chi_yu.DTOs.Mappers.MoveMapper;
import com.pokeCalc.chi_yu.DTOs.Request.MoveGenerationDataRequestDto;
import com.pokeCalc.chi_yu.DTOs.Request.MoveRequestDto;
import com.pokeCalc.chi_yu.DTOs.Response.MoveGenerationDataResponseDto;
import com.pokeCalc.chi_yu.DTOs.Response.MoveResponseDto;
import com.pokeCalc.chi_yu.Entities.Move;
import com.pokeCalc.chi_yu.Entities.MoveGenerationData;
import com.pokeCalc.chi_yu.Repositories.MoveGenerationDataRepository;
import com.pokeCalc.chi_yu.Repositories.MoveRepository;
import com.pokeCalc.chi_yu.Services.MoveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class MoveServiceImpl implements MoveService {

    private final MoveMapper moveMapper;

    private final MoveRepository moveRepository;

    private final MoveGenerationDataRepository moveGenerationDataRepository;

    @Override
    public MoveResponseDto createMove(MoveRequestDto moveDto) {
        Move entity = moveMapper.dtoToEntity(moveDto);
        Move savedEntity = moveRepository.save(entity);
        return moveMapper.entityToDto(savedEntity);
    }

    @Override
    public MoveResponseDto getMove(UUID moveId) {
        return moveMapper.entityToDto(buscarMove(moveId));
    }

    @Override
    public MoveResponseDto updateMove(UUID moveId, MoveRequestDto moveRequestDto) {
        Move existingMove = buscarMove(moveId);
        existingMove.setMoveName(moveRequestDto.moveName());
        Move updatedMove = moveRepository.save(existingMove);
        return moveMapper.entityToDto(updatedMove);
    }

    @Override
    public void deleteMove(UUID id) {
        Move moveToDelete = buscarMove(id);
        moveRepository.delete(moveToDelete);
    }

    //ADD LOGICA DE GARANTIR APENAS UMA REGRA PARA CADA GERACAO
    @Override
    public MoveResponseDto addMoveGenerationData(UUID moveId, MoveGenerationDataRequestDto dto) {
        Move move = buscarMove(moveId);

        if(move.getMoveGenerationData() == null){
            move.setMoveGenerationData(new ArrayList<>());
        }

        if (move.getMoveGenerationData().stream().anyMatch(moveGenerationData -> moveGenerationData.getGeneration()==dto.generation())){
             throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Já existem dados do move " + move.getMoveName()
                            + " na geração " + dto.generation() + " salvos");
        }
        MoveGenerationData newGenData = moveMapper.dtoGenDataToEntity(dto);
        newGenData.setMove(move);

        move.getMoveGenerationData().add(newGenData);
        Move savedMove = moveRepository.save(move);
        return moveMapper.entityToDto(savedMove);
    }

    @Override
    public MoveGenerationDataResponseDto getMoveGenerationData(UUID id) {
        MoveGenerationData moveGenerationData = buscarMoveGenData(id);
        return moveMapper.entityToDtoGenDataResponse(moveGenerationData);
    }

    @Override
    public MoveGenerationDataResponseDto editMoveGenerationData(UUID moveGenDataId, MoveGenerationDataRequestDto dto) {
        MoveGenerationData generationData = buscarMoveGenData(moveGenDataId);

        generationData.setBaseDamage(dto.baseDamage());
        generationData.setMoveType(dto.moveType());
        generationData.setType(dto.elementalType());

        MoveGenerationData savedMoveData = moveGenerationDataRepository.save(generationData);

        return moveMapper.entityToDtoGenDataResponse(savedMoveData);
    }

    @Override
    public MoveResponseDto deleteMoveGenerationData(UUID moveGenDataId) {
        MoveGenerationData moveDataToDelete = buscarMoveGenData(moveGenDataId);
        Move movesData = moveDataToDelete.getMove();
        moveGenerationDataRepository.delete(moveDataToDelete);
        return moveMapper.entityToDto(movesData);
    }

    private Move buscarMove(UUID id){
        return moveRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Move não encontrado com o id: " + id));
    }

    private MoveGenerationData buscarMoveGenData(UUID id) {
        return moveGenerationDataRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Dados da geração não encontrados para o id: " + id));
    }
}

