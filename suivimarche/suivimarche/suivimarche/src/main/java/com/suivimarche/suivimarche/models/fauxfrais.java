package com.suivimarche.suivimarche.models;

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
@Table(name="fauxfrais")
public class fauxfrais {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int idff;
private String fftype;
private float ffmontant;
}
