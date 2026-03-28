package com.pokeCalc.chi_yu.Repositories;

import com.pokeCalc.chi_yu.Entities.PokemonSpecie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PokeSpecieRepository extends JpaRepository<PokemonSpecie,UUID> {
}
