package com.pokeCalc.chi_yu.Entities;
import com.pokeCalc.chi_yu.Entities.Enums.Game;
import com.pokeCalc.chi_yu.Entities.Enums.Generation;
import com.pokeCalc.chi_yu.Entities.Enums.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PokemonStatHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Embedded
    private BaseStats stats;

    @Column(name = "game", nullable = false)
    private Game game;

    @Transient
    public Generation getGeneration(){
        return this.game.getGeneration();
    }

    @ManyToOne
    @JoinColumn(name = "pokemon_form_id")
    private PokemonForm pokemonForm;

    @OneToMany(mappedBy = "statHistory", cascade = CascadeType.ALL)
    private List<PokemonAbillityList> pokemonAbilities;

    @Enumerated(EnumType.STRING)
    private Type primaryType;

    @Enumerated(EnumType.STRING)
    private Type secondaryType;
}
