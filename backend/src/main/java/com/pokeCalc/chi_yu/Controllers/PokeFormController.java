package com.pokeCalc.chi_yu.Controllers;
import com.pokeCalc.chi_yu.DTOs.Mappers.PokeFormMapper;
import com.pokeCalc.chi_yu.DTOs.Request.PokeFormRequestDto;
import com.pokeCalc.chi_yu.DTOs.Response.PokeFormResponseDto;
import com.pokeCalc.chi_yu.Services.PokeFormService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/forms")
public class PokeFormController {

    private final PokeFormMapper pokeFormMapper;

    private final PokeFormService pokeFormService;

    @PostMapping
    public ResponseEntity<PokeFormResponseDto> createPokemonForm(@RequestBody PokeFormRequestDto dto){
        PokeFormResponseDto responseDto = pokeFormService.createPokeForm(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PokeFormResponseDto> getPokemonForm(@PathVariable UUID id){
        PokeFormResponseDto responseDto = pokeFormService.getPokeForm(id);
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PokeFormResponseDto> updatePokemonForm(@PathVariable UUID id, @RequestBody PokeFormRequestDto dto){
        PokeFormResponseDto responseDto = pokeFormService.updatePokeForm(id, dto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePokemonForm(@PathVariable UUID id){
        pokeFormService.deletePokeForm(id);
    }

}
