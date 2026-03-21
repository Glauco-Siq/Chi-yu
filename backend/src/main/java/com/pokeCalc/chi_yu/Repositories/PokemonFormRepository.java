package com.pokeCalc.chi_yu.Repositories;
import com.pokeCalc.chi_yu.Entities.PokemonForm;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface PokemonFormRepository extends JpaRepository<PokemonForm, UUID> {
}
