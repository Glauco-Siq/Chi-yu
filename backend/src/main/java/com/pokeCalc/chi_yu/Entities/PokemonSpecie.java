package com.pokeCalc.chi_yu.Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pokemon_specie")
public class PokemonSpecie {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(nullable = false, name = "national_dex_number")
    private int nationaDexNumber;

    @Column(nullable = false, name = "pokemon_name")
    private String pokemonName;

    @OneToMany(mappedBy = "specie", cascade = CascadeType.ALL)
    private List<PokemonForm> forms;


}
