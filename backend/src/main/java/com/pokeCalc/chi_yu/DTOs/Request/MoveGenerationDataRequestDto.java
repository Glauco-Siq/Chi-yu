package com.pokeCalc.chi_yu.DTOs.Request;
import com.pokeCalc.chi_yu.Entities.Enums.Generation;
import com.pokeCalc.chi_yu.Entities.Enums.MoveType;
import com.pokeCalc.chi_yu.Entities.Enums.Type;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record MoveGenerationDataRequestDto (@PositiveOrZero Integer baseDamage,
                                            @NotNull(message = "The move type (PHISYCAL, SPECIAL, STATUS) is needed")
                                            MoveType moveType,
                                            @NotNull(message = "The generation is needed")Generation generation,
                                            @NotNull(message = "The elemental Type is needed)")Type elementalType){
}
