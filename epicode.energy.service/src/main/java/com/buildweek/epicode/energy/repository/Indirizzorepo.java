package com.buildweek.epicode.energy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buildweek.epicode.energy.model.Comune;
import com.buildweek.epicode.energy.model.Indirizzo;

public interface Indirizzorepo extends JpaRepository<Indirizzo, Long>{

}
