package com.tarun.rest.webservices.restful_web_services.user;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name ="user_details")
public class User {
	
	protected User()
	{
		
	}
	@Size(min = 2, message="Name should have atleast 2 characters")
	@JsonProperty("user_name")
	private String name;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Past(message="Bithdate should be in the past")
	@JsonProperty("dateOfBirth")
	private LocalDate dob;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Post> posts;

	public User(String name, Integer id, LocalDate dob) {
		super();
		this.name = name;
		this.id = id;
		this.dob = dob;
	}

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

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + ", dob=" + dob + "]";
	}

	

}
