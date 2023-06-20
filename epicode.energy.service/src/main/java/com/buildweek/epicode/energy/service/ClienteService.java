package com.buildweek.epicode.energy.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.io.RandomAccessFileMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import com.buildweek.epicode.energy.enums.TipoCliente;
import com.buildweek.epicode.energy.model.Cliente;
import com.buildweek.epicode.energy.model.Comune;
import com.buildweek.epicode.energy.model.Fattura;
import com.buildweek.epicode.energy.model.Indirizzo;
import com.buildweek.epicode.energy.repository.ClientiRepo;
import com.buildweek.epicode.energy.repository.Indirizzorepo;
import com.github.javafaker.Faker;

import jakarta.persistence.EntityNotFoundException;

@Service

public class ClienteService {
	Faker fk = new Faker(new Locale("IT-it"));
	Random random = new Random();
	@Autowired
	ComuneService sc;
	@Autowired
	ClientiRepo dbcliente;
	@Autowired
	IndirizzoService dbindirizzo;

	public void Creafake() {

		Cliente cliente = new Cliente();
		cliente.setNomeContatto(fk.name().firstName());
		cliente.setCognomeContatto(fk.name().lastName());
		cliente.setDataInserimento(getRandomDateBetween(LocalDate.of(2002, 01, 01), LocalDate.now()));
		cliente.setDataUltimoContatto(getRandomDateBetween(LocalDate.of(2005, 01, 01), LocalDate.now()));
		cliente.setEmail(cliente.getCognomeContatto() + "." + cliente.getNomeContatto() + "@gmail.com");
		cliente.setEmailContatto(cliente.getCognomeContatto() + "." + cliente.getNomeContatto() + "@outlook.com");
		// sistemare importo fattura - troppo grande
		cliente.setFatturatoAnnuale(fk.random().nextLong());
		cliente.setIndirizzoSedeLegale(RandomAdress());
		cliente.setTelefonoContatto(fk.phoneNumber().cellPhone());
		cliente.setPartitaIva(fk.regexify("[0-9]{11}"));
		cliente.setRagioneSociale(fk.company().name());
		cliente.setIndirizzoSedeOperativa(RandomAdress());
		cliente.setTelefono(fk.phoneNumber().phoneNumber());
		cliente.setPec(cliente.getCognomeContatto() + "." + cliente.getNomeContatto() + "@pec.com");
		TipoCliente[] tipiCliente = TipoCliente.values();
		cliente.setTipoCliente(tipiCliente[random.nextInt(tipiCliente.length)]);
		dbcliente.save(cliente);

	}

	public  LocalDate getRandomDateBetween(LocalDate startDate, LocalDate endDate) {
		long startEpochDay = startDate.toEpochDay();
		long randomDay = ThreadLocalRandom.current().nextLong(startEpochDay, endDate.toEpochDay() + 1);
		return LocalDate.ofEpochDay(randomDay);
	}

	private Indirizzo RandomAdress() {

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
	
	public List<Cliente> getAll(){
		return dbcliente.findAll();
	}
	
	public Cliente getById(Long id) {
		if(!dbcliente.existsById(id)) {
			throw new EntityNotFoundException("Cliente non presente nel DataBase!");
		}
		return dbcliente.findById(id).get();
	}

}
