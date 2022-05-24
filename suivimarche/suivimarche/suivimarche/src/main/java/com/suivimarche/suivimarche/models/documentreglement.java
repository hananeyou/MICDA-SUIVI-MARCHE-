package com.suivimarche.suivimarche.models;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity 
@Table(name="documentreglement")
@Data @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class documentreglement {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int drid;
	private float drnum;
	private String dretat;
	private String drtype;
	private Date drdateencaisse;
	private Date drdateecheance;
}