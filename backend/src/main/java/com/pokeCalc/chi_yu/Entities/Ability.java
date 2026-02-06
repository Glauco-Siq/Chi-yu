package com.pokeCalc.chi_yu.Entities;

import com.pokeCalc.chi_yu.Entities.Enums.AbilityType;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "abilities")
public class Ability {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(length = 1000)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AbilityType type;
}
