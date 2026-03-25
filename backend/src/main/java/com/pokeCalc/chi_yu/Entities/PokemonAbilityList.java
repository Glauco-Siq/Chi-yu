package com.pokeCalc.chi_yu.Entities;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class PokemonAbilityList {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "pokemon_history_id", nullable = false)
    private PokemonStatHistory pokeStatHistory;

    @ManyToOne
    @JoinColumn(name = "ability_id", nullable = false)
    private Ability ability;

    @Column(nullable = false)
    private boolean isHiddenAbility;
}
