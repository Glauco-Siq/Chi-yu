package com.pokeCalc.chi_yu.Services.Impl;
import com.pokeCalc.chi_yu.DTOs.Mappers.MoveMapper;
import com.pokeCalc.chi_yu.DTOs.Request.MoveGenerationDataRequestDto;
import com.pokeCalc.chi_yu.DTOs.Request.MoveRequestDto;
import com.pokeCalc.chi_yu.DTOs.Response.MoveGenerationDataResponseDto;
import com.pokeCalc.chi_yu.DTOs.Response.MoveResponseDto;
import com.pokeCalc.chi_yu.Entities.Enums.Generation;
import com.pokeCalc.chi_yu.Entities.Move;
import com.pokeCalc.chi_yu.Entities.MoveGenerationData;
import com.pokeCalc.chi_yu.Repositories.MoveRepository;
import com.pokeCalc.chi_yu.Services.MoveService;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.orm.jpa.persistenceunit.PersistenceManagedTypes;
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
    @Autowired
    private PersistenceManagedTypes persistenceManagedTypes;

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
    public MoveGenerationDataResponseDto editMoveGenerationData(UUID moveId, MoveGenerationDataRequestDto dto) {
        Move move = moveRepository.findById(moveId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Move não encontrado com o id: " + moveId));

        if(move.getMoveGenerationData() == null || move.getMoveGenerationData().isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Este ataque não tem nenhum dado de quaisquer geração" +
                    "atrelado a ele");
        }

        MoveGenerationData generationData = move.getMoveGenerationData().stream()
                        .filter(genData -> genData.getGeneration() == dto.generation())
                        .findFirst().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Dados da geração " + dto.generation() + " não encontrados para o ataque " + move.getMoveName()));

        generationData.setBaseDamage(dto.baseDamage());
        generationData.setMoveType(dto.moveType());
        generationData.setType(dto.elementalType());
        generationData.setGeneration(dto.generation());

        Move savedMove = moveRepository.save(move);
        return moveMapper.entityToDtoGenDataResponse(generationData);
    }


}
