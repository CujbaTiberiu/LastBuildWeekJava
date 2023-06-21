package com.buildweek.epicode.energy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buildweek.epicode.energy.model.Cliente;
import com.buildweek.epicode.energy.model.Comune;
import com.buildweek.epicode.energy.repository.ComuneRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ComuneService {
	
	@Autowired
	 ComuneRepository db;
	
	//Aggiunta Comune
	public  Comune add(Comune comune) {
		return db.save(comune);
	}
	
	//Ricerca Comune per Id
	public Comune getById(Long id) {
		return db.findById(id).get();
	}
	
	//Ricerca tutti Comuni
	public List<Comune> GetAllComuni(){
		return db.findAll();
		
	}
	
	//Modifica Comune
	public Optional<?> putComune(Comune comune) {
		if(!db.existsById(comune.getId())) {
			throw new EntityNotFoundException("Comune non esiste");
		}else {
			return Optional.of(db.save(comune));
		}
	}
	
	//Cancellazione
	public String deleteComune(Long id){
		db.deleteById(id);
		return "Comune Cancellato";
	}	
} 

