package com.buildweek.epicode.energy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.buildweek.epicode.energy.model.Fattura;
import com.buildweek.epicode.energy.service.ClienteService;
import com.buildweek.epicode.energy.service.FatturaService;

@RestController
@RequestMapping("/api/fatture")
public class FatturaController {
	
	@Autowired FatturaService fs;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(fs.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@RequestParam long id){
		return ResponseEntity.ok(fs.getById(id));
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Fattura fattura){
		return ResponseEntity.ok(fs.save(fattura));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> save(@RequestBody Fattura fattura , @RequestParam long id){
		return ResponseEntity.ok(fs.update(fattura, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@RequestParam long id){
		return ResponseEntity.ok(fs.deleteById(id));
	}
	
	
	
	
	
	
	
	
	
	
	
}
