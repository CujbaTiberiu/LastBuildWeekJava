package com.buildweek.epicode.energy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.buildweek.epicode.energy.model.Comune;

@Repository
public interface ComuneRepository extends JpaRepository<Comune, Long>{

}
