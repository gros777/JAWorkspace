package me.victorhernandez.hellospring.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import me.victorhernandez.hellospring.dao.GenericDao;
@Entity
public class Task implements Serializable, DomainObject {

	private Long id;
    private String description;
    private Usuario asignedUser;
    private Date taskDate;
    private Integer version;
    
    @Id
    @GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@ManyToOne
	public Usuario getAsignedUser() {
		return asignedUser;
	}
	public void setAsignedUser(Usuario asignedUser) {
		this.asignedUser = asignedUser;
	}
	@Temporal(TemporalType.TIMESTAMP)
	public Date getTaskDate() {
		return taskDate;
	}
	public void setTaskDate(Date taskDate) {
		this.taskDate = taskDate;
	}
	@Version
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
    
}
