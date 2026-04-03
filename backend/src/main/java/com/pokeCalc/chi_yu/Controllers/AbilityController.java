package com.pokeCalc.chi_yu.Controllers;
import com.pokeCalc.chi_yu.DTOs.Mappers.AbilityMapper;
import com.pokeCalc.chi_yu.DTOs.Request.AbilityRequestDto;
import com.pokeCalc.chi_yu.DTOs.Response.AbilityResponseDto;
import com.pokeCalc.chi_yu.Services.AbilityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/abilities")
public class AbilityController {

    private final AbilityService abilityService;

    private final AbilityMapper abilityMapper;

    @PostMapping
    public ResponseEntity<AbilityResponseDto> createAbility(@RequestBody @Valid AbilityRequestDto dto){
        AbilityResponseDto response = abilityService.createAbility(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AbilityResponseDto> getAbility(@PathVariable UUID id){
        AbilityResponseDto responseDto = abilityService.getAbility(id);
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AbilityResponseDto> updateAbility(@PathVariable UUID id, @RequestBody @Valid AbilityRequestDto dto){
        AbilityResponseDto responseDto = abilityService.updateAbility(id, dto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAbility(@PathVariable UUID id){
        abilityService.deleteAbility(id);
    }
}
