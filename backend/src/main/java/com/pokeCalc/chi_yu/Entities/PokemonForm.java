package com.pokeCalc.chi_yu.Entities;
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

    @Column (name = "form_name")
    private String formName;

    @ManyToOne
    @JoinColumn( name = "pokemon_specie_id", nullable = false)
    private PokemonSpecie specie;

    @OneToMany(mappedBy = "pokemonForm")
    private List<PokemonStatHistory> pokemonStatHistory;
    
}