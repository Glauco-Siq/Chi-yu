package com.pokeCalc.chi_yu.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table
public class PokemonForm {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;

    @Column (name = "form_name")
    private String formName;

    @ManyToOne
    @JoinColumn( name = "pokemon_specie_id", nullable = false)
    @JsonIgnore
    private PokemonSpecie specie;

    @OneToMany(mappedBy = "pokemonForm", cascade = CascadeType.ALL)
    private List<PokemonStatHistory> pokemonStatHistory;
    
}