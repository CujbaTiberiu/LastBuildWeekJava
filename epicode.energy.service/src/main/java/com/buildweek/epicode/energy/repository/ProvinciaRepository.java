package com.buildweek.epicode.energy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.buildweek.epicode.energy.model.Provincia;
import java.util.List;


@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Long>{
	
	public Provincia findByNome(String nome);

}
