package me.victorhernandez.struts2.pra.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "Category.findCategoryWithProduct",
			query = "select distinct c from Category c left join fetch c.products p") })
public class Category implements DomainObject {

	private Long categoryId;
	private String categoryName;
	private Integer version;
	private Set<Product> products = new HashSet<Product>();

	/**
	 * @return the categoriId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "category_id_generaror")
	@SequenceGenerator(name = "category_id_generaror", sequenceName = "CATEGORY_ID_GEN")
	public Long getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoriId
	 *            the categoriId to set
	 */
	public void setCategoryId(Long categoriId) {
		this.categoryId = categoriId;
	}

	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName
	 *            the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * @return the version
	 */
	@Version
	public Integer getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * @return the products
	 */
	@OneToMany(mappedBy = "category",  fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	public Set<Product> getProducts() {
		return products;
	}

	/**
	 * @param products
	 *            the products to set
	 */
	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public void addProductToCategory(Product product){
		product.setCategory(this);
		getProducts().add(product);
	}
	public void removeProductFromCategory(Product product){
		getProducts().remove(product);
		product.setCategory(null);
	}
	public void copyFrom(DomainObject origin) {
		Category source = (Category)origin;
		this.categoryName = source.categoryName;
		this.products = source.products;
	}
}
