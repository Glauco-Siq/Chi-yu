package com.pokeCalc.chi_yu.Entities;

import com.pokeCalc.chi_yu.Entities.Enums.Type;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table
public class PokemonForm {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private String id;

    @OneToMany(mappedBy = "pokemonForm", cascade = CascadeType.ALL)
    private List<PokemonAbillityList> pokemonAbilities;

    @Column (name = "form_name")
    private String formName;

    @Enumerated(EnumType.STRING)
    private Type primaryType;

    @Enumerated(EnumType.STRING)
    private Type secondaryType;

    @Embedded
    private BaseStats baseStats;

    @ManyToOne
    @JoinColumn( name = "pokemon_specie_id", nullable = false)
    private PokemonSpecie specie;

}