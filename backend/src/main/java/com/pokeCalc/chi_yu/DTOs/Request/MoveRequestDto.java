package com.pokeCalc.chi_yu.DTOs.Request;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record MoveRequestDto(@NotBlank String moveName){
}
