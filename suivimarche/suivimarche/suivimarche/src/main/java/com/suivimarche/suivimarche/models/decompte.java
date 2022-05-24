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
@Table(name="decompte")
public class decompte {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int idd;
private Date ddate;
private String dobjet;
private float dmontant;
private String dtype;
private String dpourcentage;
private String detat;
private String dpiece;

}
