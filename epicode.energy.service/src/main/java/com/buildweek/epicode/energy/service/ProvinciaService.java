package com.buildweek.epicode.energy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buildweek.epicode.energy.model.Provincia;
import com.buildweek.epicode.energy.repository.ProvinciaRepository;

@Service
public class ProvinciaService {
	
	@Autowired ProvinciaRepository db;
	
	public Provincia save(Provincia p) {
		return db.save(p);
	}
public Provincia FindByName(String name) {
	return db.findByNome(name);
	
}
}
