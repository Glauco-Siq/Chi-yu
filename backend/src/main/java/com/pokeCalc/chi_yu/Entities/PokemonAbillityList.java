package com.pokeCalc.chi_yu.Entities;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PokemonAbillityList {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "pokemon_history_id", nullable = false)
    private PokemonStatHistory pokeStatHistory;

    @ManyToOne
    @JoinColumn(name = "ability_id", nullable = false)
    private Ability ability;

    @Column(nullable = false)
    private boolean isHiddenAbility;
}
