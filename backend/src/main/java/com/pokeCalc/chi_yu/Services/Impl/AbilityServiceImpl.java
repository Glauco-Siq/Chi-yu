package com.pokeCalc.chi_yu.Services.Impl;
import com.pokeCalc.chi_yu.DTOs.Mappers.AbilityMapper;
import com.pokeCalc.chi_yu.DTOs.Request.AbilityRequestDto;
import com.pokeCalc.chi_yu.DTOs.Response.AbilityResponseDto;
import com.pokeCalc.chi_yu.Entities.Ability;
import com.pokeCalc.chi_yu.Repositories.AbilityRepository;
import com.pokeCalc.chi_yu.Services.AbilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AbilityServiceImpl implements AbilityService {

    @Autowired
    AbilityMapper abilityMapper;

    @Autowired
    AbilityRepository abilityRepository;

    //Colocar uma checagem pra nao deixar criar uma abilidade com mesmo nome
    @Override
    public AbilityResponseDto createAbility(AbilityRequestDto dto){
        Ability ability = abilityMapper.dtoToEntity(dto);

        if(abilityRepository.existsByName(dto.name())){
            throw new IllegalArgumentException("Já existe uma habilidade cadastrada com o nome: "+ dto.name());
        }

        abilityRepository.save(ability);
        return abilityMapper.entityToDto(ability);
    }

    @Override
    public AbilityResponseDto getAbility(UUID abilityId){
        Ability ability = abilityRepository.findById(abilityId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Abilidade não encontrada com o id: "+ abilityId));
        return abilityMapper.entityToDto(ability);
    }

    @Override
    public AbilityResponseDto updateAbility(UUID abilityId, AbilityRequestDto dto){
        Ability ability = abilityRepository.findById(abilityId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Abilidade não encontrada com o id: "+ abilityId));
        ability.setName(dto.name());
        ability.setDescription(dto.description());
        ability.setType(dto.abilityType());
        Ability newAbility = abilityRepository.save(ability);
        return abilityMapper.entityToDto(newAbility);
    }
}
