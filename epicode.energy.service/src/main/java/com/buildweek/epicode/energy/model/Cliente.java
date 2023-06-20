package com.buildweek.epicode.energy.model;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CollectionId;
import com.buildweek.epicode.energy.enums.TipoCliente;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "clienti")
public class Cliente {
	
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @Column(name = "cognome_contatto")
	 private String cognomeContatto;
	 
	 @Column(name = "data_inserimento")
	 private LocalDate dataInserimento;
	 
	 @Column(name = "data_ultimo_contatto")
	 private LocalDate dataUltimoContatto;
	 
	 @Column(nullable = false, unique = true)
	 private String email;
	 
	 @Column(name = "email_contatto",nullable = false, unique = true)
	 private String emailContatto;
	 
	 @Column(name = "fatturato_annuale")
	 private Long fatturatoAnnuale;
	 
	 @Column(name = "nome_contatto")
	 private String nomeContatto;
	 
	 @Column(name = "partita_iva", nullable = false)
	 private String partitaIva;
	 
	 @Column(nullable = false, unique = true)
	 private String pec;
	 
	 @Column(name = "ragione_sociale")
	 private String ragioneSociale;
	 
	 private String telefono;
		
	 @Column(name = "telefono_contatto")
	 private String telefonoContatto;
	 
	 @Enumerated(EnumType.STRING)
	 @Column(name = "tipo_cliente",nullable = false)
	 private TipoCliente tipoCliente;
	 
	 @OneToOne
	 @JoinColumn(name = "indirizzo_sede_legale_id", nullable = false)
	 private Indirizzo indirizzoSedeLegale;
	 
	 @OneToOne
	 @JoinColumn(name = "indirizzo_sede_operativa_id")
	 private Indirizzo indirizzoSedeOperativa;
	 
	 @OneToMany(fetch = FetchType.EAGER, mappedBy = "cliente")
	 
	 @Column(name="fatture")
	 private List<Fattura> listafatture;
	 
	 
}



/*CREATE TABLE public.be_service_clienti (
    id bigint DEFAULT nextval('public.be_service_clienti_id_seq'::regclass) NOT NULL,*
    cognome_contatto character varying(255),*
    data_inserimento timestamp without time zone,*
    data_ultimo_contatto timestamp without time zone,
    email character varying(255),
    email_contatto character varying(255),
    fatturato_annuale numeric(19,2),
    nome_contatto character varying(255),
    partita_iva character varying(255),
    pec character varying(255),
    ragione_sociale character varying(255),
    telefono character varying(255),
    telefono_contatto character varying(255),
    tipo_cliente character varying(255),
    indirizzo_sede_legale_id bigint,
    indirizzo_sede_operativa_id bigint
);*/


















