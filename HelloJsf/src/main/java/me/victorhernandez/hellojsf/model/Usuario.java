package me.victorhernandez.hellojsf.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class Usuario {

	private Long id;
	@NotNull(message = "Please enter username")
    private String username;
	@NotNull(message = "Please enter password")
    private String password;
	@NotNull(message = "Please enter email")
    private String email;
    private Date birthdate;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
}
