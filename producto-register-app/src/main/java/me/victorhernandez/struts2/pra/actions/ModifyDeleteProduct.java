package me.victorhernandez.struts2.pra.actions;

import me.victorhernandez.struts2.pra.domain.Product;
import me.victorhernandez.struts2.pra.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ModifyDeleteProduct extends ActionSupport implements ModelDriven<Product>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 550044562490715040L;

	private Long id;
	@Autowired
	@Qualifier(value="productService")
	private ProductService productService;
	private Product product;
	
	public Product getProduct() {
		return product;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	@Override
	public String execute() throws Exception {
		product =  productService.getProduct(id);
		return SUCCESS;
	}

	public Product getModel() {
		return product;
	}
}
