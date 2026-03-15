package com.pokeCalc.chi_yu.Entities;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class BaseStats {
    private int hp;
    private int attack;
    private int defense;
    private int spAttack;
    private int spDefense;
    private int Speed;

}
