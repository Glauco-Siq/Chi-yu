package com.pokeCalc.chi_yu.Repositories;

import com.pokeCalc.chi_yu.Entities.Move;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MoveRepository extends JpaRepository<Move, UUID> {
}
