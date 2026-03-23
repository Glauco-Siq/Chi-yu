package com.pokeCalc.chi_yu.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pokeCalc.chi_yu.Entities.Enums.Generation;
import com.pokeCalc.chi_yu.Entities.Enums.MoveType;
import com.pokeCalc.chi_yu.Entities.Enums.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class MoveGenerationData {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "move_id")
    @JsonIgnore
    private Move move;

    @Column(name = "move_base_damage")
    private Integer baseDamage;

    @Enumerated(EnumType.STRING)
    @Column(name = "move_type")
    private MoveType moveType;

    @Enumerated(EnumType.STRING)
    @Column(name = "generation")
    private Generation generation;

    @Enumerated(EnumType.STRING)
    @Column(name = "elemental_type")
    private Type type;
}
