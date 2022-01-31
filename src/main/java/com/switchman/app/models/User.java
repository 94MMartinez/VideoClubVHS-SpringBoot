package com.switchman.app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="users")
@Getter
@Setter
public class User {
	
	@Column (name = "nombre") 
	private String name;
	
	@Column (name = "apellido")
	private String surname;
	
	@Column (name = "email")
	private String email;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private Long id;
	
	@Column (name = "password")
	private String password;

}