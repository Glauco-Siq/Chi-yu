package com.pokeCalc.chi_yu.DTOs.Mappers;
import com.pokeCalc.chi_yu.DTOs.Request.AbilityRequestDto;
import com.pokeCalc.chi_yu.DTOs.Response.AbilityResponseDto;
import com.pokeCalc.chi_yu.Entities.Ability;
import org.springframework.stereotype.Component;

@Component
public class AbilityMapper {
    public AbilityResponseDto entityToDto(Ability ability){
        AbilityResponseDto dto = new AbilityResponseDto(ability.getId(), ability.getName(), ability.getDescription(), ability.getType());
        return dto;
    }

    public Ability dtoToEntity(AbilityRequestDto dto){
        Ability ability = new Ability();
        ability.setName(dto.name());
        ability.setType(dto.abilityType());
        ability.setDescription(dto.description());
        return ability;
    }
}
