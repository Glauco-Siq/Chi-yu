package com.pokeCalc.chi_yu.Repositories;

import com.pokeCalc.chi_yu.Entities.MoveGenerationData;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface MoveGenerationDataRepository extends JpaRepository<MoveGenerationData, UUID> {
}
