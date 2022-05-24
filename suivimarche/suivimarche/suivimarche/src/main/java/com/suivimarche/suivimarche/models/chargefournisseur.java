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
@Data @Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity 
@Table(name="chargefournisseur")
public class chargefournisseur{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int chid;
	private float chmontant;
	private String cfprctgpaye;
	
	@OneToMany(targetEntity = fournisseur.class,cascade = CascadeType.ALL)
	@JoinColumn(name="chid_frid",referencedColumnName = "chid")
	private List<fournisseur > fournisseurs ;
		
		
		
		
		
		
		
		
	}

