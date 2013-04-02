package me.victorhernandez.struts2.pra.actions;

import java.util.Date;

import me.victorhernandez.struts2.pra.domanin.Product;
import me.victorhernandez.struts2.pra.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.opensymphony.xwork2.ActionSupport;

public class AddProductAction extends ActionSupport {

	
	private String productName;
	private Date goodThough;
	private int availables;
	private String mark;
	private String shelve;
	private int version;
	
	@Autowired
	@Qualifier(value="productService")
	private ProductService productService;
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public String execute() throws Exception{
		Product newProduct = new Product();
		newProduct.setVersion(1);
		newProduct.setAvailables(availables);
		newProduct.setGoodThough(goodThough);
		newProduct.setMark(mark);
		newProduct.setProductName(productName);
		newProduct.setShelve(shelve);
		productService.persistProduct(newProduct);
		
		return SUCCESS;
	}
}
