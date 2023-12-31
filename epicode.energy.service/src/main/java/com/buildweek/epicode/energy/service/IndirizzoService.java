package com.buildweek.epicode.energy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buildweek.epicode.energy.model.Comune;
import com.buildweek.epicode.energy.model.Indirizzo;
import com.buildweek.epicode.energy.repository.Indirizzorepo;

import jakarta.persistence.EntityNotFoundException;

@Service

public class IndirizzoService {
	@Autowired Indirizzorepo db ;
	
	//Creazione di un indirizzo
	public Indirizzo Save (Indirizzo i) {
		return db.save(i);
	}

	//Ricerca Indirizzo per Id
	public Indirizzo getById(Long id) {
		return db.findById(id).get();
	}
	
	//Ricerca tutti Indirizzo
	public List<Indirizzo> GetAllIndirizzo(){
		return db.findAll();
		
	}
	
	//Modifica Indirizzo
	public Optional<?> putIndirizzo(Indirizzo indirizzo) {
		if(!db.existsById(indirizzo.getId())) {
			throw new EntityNotFoundException("Indirizzo non esiste");
		}else {
			return Optional.of(db.save(indirizzo));
		}
	}
	
	//Cancellazione
	public String deleteIndirizzo(Long id){
		db.deleteById(id);
		return "Indirizzo Cancellato";
	}	
}
