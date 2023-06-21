package com.buildweek.epicode.energy.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.buildweek.epicode.energy.enums.StatoFattura;
import com.buildweek.epicode.energy.model.Comune;
import com.buildweek.epicode.energy.model.Fattura;

@Repository
public interface FatturaRepository  extends JpaRepository<Fattura, Long>{

	public List<Fattura> findBystatofattura(StatoFattura statofattura);
	public List<Fattura>findByData(LocalDate data);
	public  List<Fattura> findByAnno(Integer anno);
	
	@Query("SELECT c FROM Cliente c WHERE c.fatturatoAnnuale >= :minImporto AND c.fatturatoAnnuale <= :maxImporto")
	public List<Fattura> findByRangeDiImporti(Long min, Long max);
	
	public List<Fattura> findByCliente(Long id);
}
