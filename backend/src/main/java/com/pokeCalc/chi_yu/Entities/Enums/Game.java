package com.pokeCalc.chi_yu.Entities.Enums;

import jakarta.persistence.GeneratedValue;
import lombok.Getter;

@Getter
public enum Game {
    SCARLET_VIOLET(Generation.GEN_9);
    //ADD AQUI NOVOS JOGOS

    private final Generation generation;

    Game(Generation generation){
        this.generation = generation;
    }
}
