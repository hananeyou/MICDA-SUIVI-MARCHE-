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
@Data @Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="facture")
public class facture {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idf;
	private Date fdate;
	private String fobjet;
	private float fmontant;
	private String ftype;
	private String fetat;

}
