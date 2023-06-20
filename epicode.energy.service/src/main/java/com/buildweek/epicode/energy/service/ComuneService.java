package com.buildweek.epicode.energy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buildweek.epicode.energy.model.Comune;
import com.buildweek.epicode.energy.repository.ComuneRepository;

@Service
public class ComuneService {
	
	@Autowired
	 ComuneRepository db;
	
	public  Comune add(Comune comune) {
		return db.save(comune);
	}
	
	public Comune getById(Long id) {
		return db.findById(id).get();
	}
	
	public List<Comune> GetAllComuni(){
		return db.findAll();
		
	}
} 

