package com.suivimarche.suivimarche.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table(name="cautiongrantie")
@Data @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class cautiongarantie {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int idcg;
private float cgmontant;
private String cgpiece;

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name="idcg_idmr")
private marche marché;


}
