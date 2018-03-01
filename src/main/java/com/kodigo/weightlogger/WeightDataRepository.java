package com.kodigo.weightlogger;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface WeightDataRepository extends JpaRepository<WeightData, Long>{

    Collection<WeightData> findByWeight(Double weight);

}
