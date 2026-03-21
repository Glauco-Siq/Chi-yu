package com.pokeCalc.chi_yu.Repositories;
import com.pokeCalc.chi_yu.Entities.PokemonStatHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PokemonStatHistoryRepository extends JpaRepository<PokemonStatHistory, UUID>{
}
