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
@Table(name="chargepersonnel")
@Data @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class chargepersonnel {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int idperso;
	private String coisdeclare;
	private String cpcnss;
	private float cpmtsalaire;
	private String cpmodesalire;
	private Date cpdaterecrute;
	private Date cpdated;
	
	@OneToMany(targetEntity = personnel.class,cascade = CascadeType.ALL)
	@JoinColumn(name="idperso_prid",referencedColumnName = "idperso")
	private List<personnel> personnels;
	
	
	
	
	
	
	
	}