package com.suivimarche.suivimarche.models;


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
@Table(name="machine")
@Data @Getter @Setter  @NoArgsConstructor @AllArgsConstructor
public class machine{
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int mid;
	private float mnumero;
	private String mtype;
	private String mresponsable;
	
	@OneToMany(targetEntity = pannemachine.class,cascade = CascadeType.ALL)
	@JoinColumn(name="mId_pmid",referencedColumnName = "mId")
	private List<pannemachine> pannemachines;
	
	
	
	
	
}