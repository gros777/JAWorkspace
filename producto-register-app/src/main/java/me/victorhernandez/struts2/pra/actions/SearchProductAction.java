package me.victorhernandez.struts2.pra.actions;

import me.victorhernandez.struts2.pra.domain.Product;
import me.victorhernandez.struts2.pra.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.opensymphony.xwork2.ActionSupport;

public class SearchProductAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2960701213513724197L;

	private String productName;
	
	@Autowired
	@Qualifier(value="productService")
	private ProductService productService;

	private Product product;
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	public Product getProduct() {
		return product;
	}

	public String execute()throws Exception{
		product = productService.getProductByName(productName);
		return SUCCESS;
	}
}
