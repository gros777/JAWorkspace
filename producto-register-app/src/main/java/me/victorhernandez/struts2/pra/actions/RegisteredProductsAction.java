package me.victorhernandez.struts2.pra.actions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import me.victorhernandez.struts2.pra.domanin.Product;
import me.victorhernandez.struts2.pra.service.ProductService;

import com.opensymphony.xwork2.ActionSupport;

public class RegisteredProductsAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1937688874303974426L;
	@Autowired
	@Qualifier(value="productService")
	private ProductService productService;
	
	List<Product> products;
	
	public List<Product> getProducts() {
		return products;
	}
	
//	public void setProducts(List<Product> products){
//		this.products=products;
//	}
	
	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public String execute() throws Exception {
//		products = productService.getAllProducts();
//		ApplicationContext context = new ClassPathXmlApplicationContext(
//				"spring-test-beans.xml");
//		RegisteredProductsAction regProds = (RegisteredProductsAction) context.getBean("registeredProductAction");
//		products = regProds.getProducts();
		products = productService.getAllProducts();
		return SUCCESS;
	}
	

}
