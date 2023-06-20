package com.buildweek.epicode.energy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.buildweek.epicode.energy.model.Cliente;
import com.buildweek.epicode.energy.model.Fattura;
@Repository
public interface ClientiRepo  extends JpaRepository<Cliente, Long> {

	
}
