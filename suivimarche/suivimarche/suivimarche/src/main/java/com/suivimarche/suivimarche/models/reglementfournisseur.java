package com.suivimarche.suivimarche.models;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity 
@Table(name="reglementfournisseur")
@Data @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class reglementfournisseur {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int rgid;
	private String rgmodepaiement;
	private float rgmontant;
	private Date dateencaisse;
	private Date dateecheance;
	
	
	

	@OneToMany(targetEntity = documentreglement.class,cascade = CascadeType.ALL)
	@JoinColumn(name="rgid_drid",referencedColumnName = "rgid")
	private List<documentreglement> documentReglements ;
	
	
	
	
	
	
}