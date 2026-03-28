package com.pokeCalc.chi_yu.Controllers;
import com.pokeCalc.chi_yu.DTOs.Mappers.PokeSpecieMapper;
import com.pokeCalc.chi_yu.DTOs.Request.SpecieRequestDto;
import com.pokeCalc.chi_yu.DTOs.Response.SpecieResponseDto;
import com.pokeCalc.chi_yu.Services.PokeSpecieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/species")
public class PokeSpecieController {

    private final PokeSpecieMapper specieMapper;
    private final PokeSpecieService pokeSpecieService;

    @PostMapping
    public ResponseEntity<SpecieResponseDto> createPokeSpecie(@RequestBody @Valid SpecieRequestDto dto){
        SpecieResponseDto response = pokeSpecieService.createSpecie(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpecieResponseDto> getPokeSpecie(@PathVariable UUID id){
        SpecieResponseDto response = pokeSpecieService.getSpecie(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SpecieResponseDto> updatePokeSpecie(@PathVariable UUID id, @RequestBody @Valid SpecieRequestDto dto){
        SpecieResponseDto response = pokeSpecieService.updateSpecie(id, dto);
        return ResponseEntity.ok(response);
    }

}
