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
@Table(name="ordreservice")
@Data @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ordreservice{
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int osid;
	private String ostype;
	private Date osdate;
	private String ospiece;
	
}