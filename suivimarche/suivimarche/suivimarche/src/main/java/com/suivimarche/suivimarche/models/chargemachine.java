package com.suivimarche.suivimarche.models;

import java.io.Serializable;
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
@Table(name="chargemachine")
@Data @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class chargemachine implements Serializable{
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int cmid;
	private String cmlieumaintenance;
	private float cmmontant;
	private String cmtypepaiement;
	
	@OneToMany(targetEntity = machine.class,cascade = CascadeType.ALL)
	@JoinColumn(name="cmid_mId",referencedColumnName = "cmid")
	private List<machine> machines;
	
	
	
	
	

	
	
	
	
	
}