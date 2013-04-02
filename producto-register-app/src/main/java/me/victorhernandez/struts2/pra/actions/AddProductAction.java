package me.victorhernandez.struts2.pra.actions;


import me.victorhernandez.struts2.pra.domanin.Product;
import me.victorhernandez.struts2.pra.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddProductAction extends ActionSupport implements ModelDriven<Product>{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6727629495086452702L;
	
	Product newProduct = new Product();
	@Autowired
	@Qualifier(value="productService")
	private ProductService productService;
	
	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	public Product getModel() {
		return newProduct;
	}

	public String execute() throws Exception{
		productService.persistProduct(newProduct);
		
		return SUCCESS;
	}

	
}
