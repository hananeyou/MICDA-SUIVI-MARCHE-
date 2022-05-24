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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity 
@Table(name="fournisseur")
@Getter  @Setter @NoArgsConstructor @AllArgsConstructor
public class fournisseur  {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int id;
	
	private int frid;
	private String frraisonsoc;
	private String fremail;
	private String frtel;
	private String fradresse;
	
	@OneToMany(targetEntity = reglementfournisseur.class,cascade = CascadeType.ALL)
	@JoinColumn(name="frid_rgid",referencedColumnName = "frid")
	private List<reglementfournisseur> reglementFournisseurs;
	
	
	
	
	
	
	
	
}