package com.pokeCalc.chi_yu.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pokeCalc.chi_yu.Entities.Enums.Game;
import com.pokeCalc.chi_yu.Entities.Enums.Generation;
import com.pokeCalc.chi_yu.Entities.Enums.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PokemonStatHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Embedded
    private BaseStats stats;

    @Column(name = "game", nullable = false)
    @Enumerated(EnumType.STRING)
    private Game game;

    @Transient
    public Generation getGeneration(){
        return this.game.getGeneration();
    }

    @ManyToOne
    @JoinColumn(name = "pokemon_form_id")
    private PokemonForm pokemonForm;

    @JsonIgnore
    @OneToMany(mappedBy = "pokeStatHistory", cascade = CascadeType.ALL)
    private List<PokemonAbilityList> abillityList;

    @Enumerated(EnumType.STRING)
    private Type primaryType;

    @Enumerated(EnumType.STRING)
    private Type secondaryType;

    @ManyToMany
    @JoinTable(
            name = "pokemon_learnable_moves",
            joinColumns = @JoinColumn(name = "form_generation_data_id"),
            inverseJoinColumns = @JoinColumn(name = "move_generation_data_id")
    )
    private List<MoveGenerationData> learnableMoves;

}
