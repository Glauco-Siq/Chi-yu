package com.pokeCalc.chi_yu.Repositories;

import com.pokeCalc.chi_yu.Entities.Ability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AbilityRepository extends JpaRepository<Ability, UUID> {
}
