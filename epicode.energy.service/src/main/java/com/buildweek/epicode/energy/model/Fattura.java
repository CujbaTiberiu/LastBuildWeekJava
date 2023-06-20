package com.buildweek.epicode.energy.model;

import java.time.LocalDate;

import com.buildweek.epicode.energy.enums.StatoFattura;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "fatture")
public class Fattura {
	@Id
	@SequenceGenerator(name = "seq2_id", sequenceName = "seq2_id", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "seq2_id")
	private Long id;

	@Enumerated(EnumType.STRING)
	private StatoFattura statofattura;
	private Integer anno;
	private LocalDate data;
	private Long importo;
	@SequenceGenerator(name = "seq5_id", sequenceName = "seq5_id", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "seq5_id")
	@Column(unique = true, nullable = false)
	private int numero;
	@ManyToOne
	@JoinColumn(name = "cliente_detail")
	private Cliente cliente;
	
	
}
