package com.pokeCalc.chi_yu.DTOs.Response;
import com.pokeCalc.chi_yu.Entities.MoveGenerationData;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

public record MoveResponseDto (UUID moveId, String moveName, List<MoveGenerationData> moveGenerationData){
}
