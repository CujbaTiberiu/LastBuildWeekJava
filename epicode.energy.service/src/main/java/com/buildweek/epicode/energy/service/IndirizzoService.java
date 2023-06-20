package com.buildweek.epicode.energy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buildweek.epicode.energy.model.Indirizzo;
import com.buildweek.epicode.energy.repository.Indirizzorepo;

@Service

public class IndirizzoService {
	@Autowired Indirizzorepo db ;
public Indirizzo Save (Indirizzo i) {
return db.save(i);
}

}
