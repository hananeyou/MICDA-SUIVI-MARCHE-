package com.suivimarche.suivimarche.models;


import java.io.Serializable;
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
@Data @Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="marche")
public class marche implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idmr ;
	private String mrcreateur ;
	private Date datecreation;
	private Date mrdatemodificattion;
	private String mrmodificateur;
	private Date mrdatevalidation;
	private String mrvalidateur;
	private String mrmotifrefu;
	private String mrstatutvalidation;
	private String mradresse;
	private String mrobjet;
	private String mrtype;
	private String mrouvrage;
	private float mrmontant;
	private float mrdelaiexecu;
	private String marchecode;
	@OneToMany(targetEntity = chargemachine.class,cascade = CascadeType.ALL)
	@JoinColumn(name="idmr_cmid",referencedColumnName = "idmr")
	private List<chargemachine> chargemachines;
	
	@OneToMany(targetEntity = chargepersonnel.class,cascade = CascadeType.ALL)
	@JoinColumn(name="idmr_idperso",referencedColumnName = "idmr")
	private List<chargepersonnel> chargepersonnel;
	
	
	@OneToMany(targetEntity = chargefournisseur.class,cascade = CascadeType.ALL)
	@JoinColumn(name="idmr_chid",referencedColumnName = "idmr")
	private List<chargefournisseur> chargeFournisseurs;
	
	
	@OneToMany(targetEntity = decompte.class,cascade = CascadeType.ALL)
	@JoinColumn(name="idmr_idd",referencedColumnName = "idmr")
	private List<decompte> decomptes;
	
	@OneToMany(targetEntity = facture.class,cascade = CascadeType.ALL)
	@JoinColumn(name="idmr_idf",referencedColumnName = "idmr")
	private List<facture> factures;
	
	@OneToMany(targetEntity = fauxfrais.class,cascade = CascadeType.ALL)
	@JoinColumn(name="idmr_idFf",referencedColumnName = "idmr")
	private List<fauxfrais> fauxfrais;
	
	
	@OneToMany(targetEntity = ordreservice.class,cascade = CascadeType.ALL)
	@JoinColumn(name="idmr_osid",referencedColumnName = "idmr")
	private List<ordreservice> ordreservice;
	
	
	@OneToMany(targetEntity = reception.class,cascade = CascadeType.ALL)
	@JoinColumn(name="idmr_idrec",referencedColumnName = "idmr")
	private List<reception > receptions ;
	 public String getmarchecode() {
		 return marchecode;
	 }
	public void setmarchecode(String marchecode) {
		this.marchecode=marchecode;
	}
	
	
	
}

