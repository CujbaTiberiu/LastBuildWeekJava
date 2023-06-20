package com.buildweek.epicode.energy.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.buildweek.epicode.energy.enums.StatoFattura;
import com.buildweek.epicode.energy.model.Cliente;
import com.buildweek.epicode.energy.model.Fattura;
import com.buildweek.epicode.energy.repository.FatturaRepository;
import com.github.javafaker.Faker;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FatturaService{

	@Autowired FatturaRepository db;
	@Autowired ClienteService dbCliente;
	
	Random random = new Random();
	
	public void createFakeFattura() {
		Faker fk = new Faker(new Locale("IT-it"));
		Fattura fattura = new Fattura();
		fattura.setAnno(fk.number().numberBetween(1999, 2024));
		fattura.setCliente(randomCliente());
		//da rivedere static/public metodo getRandomDateBetween
		fattura.setData(dbCliente.getRandomDateBetween(LocalDate.of(2002, 01, 01), LocalDate.now()));
		// sistemare importo fattura - troppo grande
		fattura.setImporto(fk.random().nextLong());
		fattura.setNumero(getLastFattura());
		StatoFattura[] statoFatture = StatoFattura.values();
		fattura.setStatofattura(statoFatture[random.nextInt(statoFatture.length)]);
		db.save(fattura);
	}

	
	public Cliente randomCliente() {
		 List<Cliente> listaClienti = dbCliente.getAll();
		 Cliente clienteRandom = listaClienti.get((int) random.nextLong(listaClienti.size()-1));
		return clienteRandom;
		
	}
	
	/*private Indirizzo RandomAdress() {

		Indirizzo indirizzo = new Indirizzo();
		indirizzo.setCap(fk.address().zipCode());
		indirizzo.setCivico(fk.address().buildingNumber());
		List<Comune> listacomuni = sc.GetAllComuni();
		indirizzo.setComune(sc.getById(random.nextLong(listacomuni.size() - 1)));
		indirizzo.setLocalita(indirizzo.getComune().getNome());
		indirizzo.setVia(fk.address().streetAddress());
		dbindirizzo.Save(indirizzo);
		return indirizzo;

	}
*/

	
	
	public Fattura save(Fattura f) {
		return db.save(f);
	}
	public int getLastFattura(){
		List<Fattura> allFatture = db.findAll();
		if (allFatture.size() > 0) {
			Fattura fattura = allFatture.get(allFatture.size()-1);
			System.out.println(fattura.getId());
			return fattura.getNumero()+1;
		} else {
			return 0;
		}
		
	}
	
	public List<Fattura> getAll(){
		return db.findAll();
	}
	
	public String deleteById(Long id) {
		db.deleteById(id);
		return "Fattura eleminata dal DataBase!";
	}
	
	public Fattura update(Fattura f, Long id) {
		if(!db.existsById(id)) {
			throw new EntityNotFoundException("Fattura non esiste nel DataBase!");
		}
		return db.save(f);
	}
	
	public List<Fattura> findBystatofattura(StatoFattura statofattura){
		return db.findBystatofattura(statofattura);
	}
	
	public List<Fattura>findByData(LocalDate data){
		return db.findByData(data);
	}
	
	public  List<Fattura> findByAnno(Integer anno){
		return db.findByAnno(anno);
	}
	public List<Fattura> findByRangeDiImporti(Long min, Long max){
		return db.findByRangeDiImporti(min, max);
	}
}
