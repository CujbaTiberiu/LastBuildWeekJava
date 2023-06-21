package com.buildweek.epicode.energy.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.buildweek.epicode.energy.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

	@Autowired ClienteService cs;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllClienti(){
		return ResponseEntity.ok(cs.getAll());
	}
	
	@GetMapping("/all/orderASC")
	public ResponseEntity<?> getAllOrderASC(){
		return ResponseEntity.ok(cs.orderByNameAsc());
	}
	
	@GetMapping("/all/orderSedeLegaleForProvinciaASC")
	public ResponseEntity<?> getAllOrderSedeLegaleForProvinciaASC(){
		return ResponseEntity.ok(cs.orderByIndirizzoSedeLegaleForProvincia());
	}
	
	@GetMapping("/all/orderNomeContattoASC")
	public ResponseEntity<?> orderByNameAsc(){
		return ResponseEntity.ok(cs.orderByNameAsc());
	}
	
	@GetMapping("/all/orderFatturaAnnualeASC")
	public ResponseEntity<?> orderByFatturaAnnuale(){
		return ResponseEntity.ok(cs.orderByFatturaAnnuale());
	}
	
	@GetMapping("/all/orderDataInserimento")
	public ResponseEntity<?> OrderByDataInserimentoAsc(){
		return ResponseEntity.ok(cs.OrderByDataInserimentoAsc());
	}
	
	
	@GetMapping(value="/all/fatturaAnnuale", params= {"fatturaAnnuale"})
	public ResponseEntity<?> findByFatturaAnnuale(@RequestParam long fatturaAnnuale){
		return ResponseEntity.ok(cs.findByFatturatoAnnuale(fatturaAnnuale));
	}
	
	@GetMapping(value="/all/dataInserimento", params= {"dataInserimento"})
	public ResponseEntity<?> findByDataInserimento(@RequestParam LocalDate dataInserimento){
		return ResponseEntity.ok(cs.findByDataInserimento(dataInserimento));
	}
	
	@GetMapping(value="/all/dataUltimoContatto", params= {"dataUltimoContatto"})
	public ResponseEntity<?> findByDataUltimoContatto(@RequestParam LocalDate dataUltimoContatto){
		return ResponseEntity.ok(cs.findByDataUltimoContatto(dataUltimoContatto));
	}
	
	@GetMapping(value="/all/parzialNomeContatto", params= {"parzialNomeContatto"})
	public ResponseEntity<?> filterByPartialName(@RequestParam String parzialNomeContatto){
		return ResponseEntity.ok(cs.filterByPartialName(parzialNomeContatto));
	}
}
