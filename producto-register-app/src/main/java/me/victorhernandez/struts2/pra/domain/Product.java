package me.victorhernandez.struts2.pra.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Product implements Serializable, DomainObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4572028568585232082L;

	private String productName;
	private Date goodThough;
	private int availables;
	private String mark;
	private String shelve;
	private Long id;
	private Integer version;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getGoodThough() {
		return goodThough;
	}
	public void setGoodThough(Date goodThough) {
		this.goodThough = goodThough;
	}
	public int getAvailables() {
		return availables;
	}
	public void setAvailables(int availables) {
		this.availables = availables;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public String getShelve() {
		return shelve;
	}
	public void setShelve(String shelve) {
		this.shelve = shelve;
	}
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Version
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
}
