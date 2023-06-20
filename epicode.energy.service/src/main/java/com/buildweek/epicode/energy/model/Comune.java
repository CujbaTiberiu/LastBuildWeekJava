package com.buildweek.epicode.energy.model;

import java.time.LocalDate;

import com.buildweek.epicode.energy.enums.TipoCliente;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@NotNull
@Table(name = "comuni")
public class Comune {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	
	 @CsvBindByName(column = "nome", required = true)
	 @CsvBindByPosition(position = 0, format = ";")
	private String nome;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	private Provincia provincia;

}
