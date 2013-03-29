package me.victorhernandez.struts2.pra.actions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import me.victorhernandez.struts2.pra.domanin.Product;
import me.victorhernandez.struts2.pra.service.ProductService;

import com.opensymphony.xwork2.ActionSupport;

public class RegisteredProductsAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1937688874303974426L;
	
	@Autowired
	@Qualifier(value="productService")
	private ProductService productService;
	
	List<Product> products;
	public List<Product> getAllProducts() {
		return products;
	}
	
	@Override
	public String execute() throws Exception {
		products = productService.getAllProducts();
		return SUCCESS;
	}
	

}
