package com.buildweek.epicode.energy.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "province")
public class Provincia {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @CsvBindByName(column = "SIGLA", required = true)
	 @CsvBindByPosition(position = 1, format = ";")
	 private String sigla;
	
	@CsvBindByName(column = "NOME", required = true)
	@CsvBindByPosition(position = 0, format = ";")
	private String nome;
	

}
