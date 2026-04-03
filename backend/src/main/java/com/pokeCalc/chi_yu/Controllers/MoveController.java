package com.pokeCalc.chi_yu.Controllers;
import com.pokeCalc.chi_yu.DTOs.Mappers.MoveMapper;
import com.pokeCalc.chi_yu.DTOs.Request.MoveGenerationDataRequestDto;
import com.pokeCalc.chi_yu.DTOs.Request.MoveRequestDto;
import com.pokeCalc.chi_yu.DTOs.Response.MoveGenerationDataResponseDto;
import com.pokeCalc.chi_yu.DTOs.Response.MoveResponseDto;
import com.pokeCalc.chi_yu.Services.MoveService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/moves")
public class MoveController {

    private final MoveService moveService;

    private final MoveMapper moveMapper;

    @PostMapping
    public ResponseEntity<MoveResponseDto> createMove(@RequestBody @Valid MoveRequestDto dto){
        MoveResponseDto response = moveService.createMove(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MoveResponseDto> getMove(@PathVariable UUID id){
        MoveResponseDto response = moveService.getMove(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MoveResponseDto> updateMove(@PathVariable UUID id, @RequestBody MoveRequestDto dto){
        MoveResponseDto response = moveService.updateMove(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMove(@PathVariable UUID id){
        moveService.deleteMove(id);
    }

    @PostMapping("{moveId}/generation-data")
    public ResponseEntity<MoveResponseDto> addGenerationData(@PathVariable UUID moveId, @RequestBody @Valid MoveGenerationDataRequestDto dto){
        MoveResponseDto response = moveService.addMoveGenerationData(moveId, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/generation-data/{id}")
    public ResponseEntity<MoveGenerationDataResponseDto> updateMoveGenData(@PathVariable UUID id, @RequestBody @Valid MoveGenerationDataRequestDto dto){
        MoveGenerationDataResponseDto response =  moveService.editMoveGenerationData(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/generation-data/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMoveGentData(@PathVariable UUID id){
        moveService.deleteMoveGenerationData(id);
    }
}
