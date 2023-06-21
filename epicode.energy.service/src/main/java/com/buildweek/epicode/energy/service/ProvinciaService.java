package com.buildweek.epicode.energy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buildweek.epicode.energy.model.Indirizzo;
import com.buildweek.epicode.energy.model.Provincia;
import com.buildweek.epicode.energy.repository.ProvinciaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProvinciaService {
	
	@Autowired ProvinciaRepository db;
	//Creazione di una Provincia
	public Provincia save(Provincia p) {
		return db.save(p);
	}
	
	//Ricerca per nome
	public Provincia FindByName(String name) {
	return db.findByNome(name);
}
	
	//Ricerca Provincia per Id
	public Provincia getById(Long id) {
		return db.findById(id).get();
	}
	
	//Ricerca tutti Provincia
	public List<Provincia> GetAllIndirizzo(){
		return db.findAll();
		
	}
	
	//Modifica Indirizzo
	public Optional<?> putIndirizzo(Provincia provincia) {
		if(!db.existsById(provincia.getId())) {
			throw new EntityNotFoundException("Provincia non esiste");
		}else {
			return Optional.of(db.save(provincia));
		}
	}
	
	//Cancellazione
	public String deleteIndirizzo(Long id){
		db.deleteById(id);
		return "Provincia Cancellato";
	}	

}
