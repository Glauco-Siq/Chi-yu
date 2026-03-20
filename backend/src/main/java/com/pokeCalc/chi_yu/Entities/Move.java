package com.pokeCalc.chi_yu.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Move {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "move_name")
    private String moveName;

    @OneToMany(mappedBy = "move")
    private List<MoveGenerationData> moveGenerationData;


}
