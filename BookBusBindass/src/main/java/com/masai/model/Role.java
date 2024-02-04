package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;

	public Role(String name) {
		super();
		this.name = name;
	}
	
	@OneToMany(mappedBy = "role")
	@JsonIgnore
	private List<User> user=new ArrayList<>();
	
	@OneToMany(mappedBy = "role")
	@JsonIgnore
	private List<Admin> admin=new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public List<Admin> getAdmin() {
		return admin;
	}

	public void setAdmin(List<Admin> admin) {
		this.admin = admin;
	}
	
	

}