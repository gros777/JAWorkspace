package me.victorhernandez.struts2.pra.actions;

import me.victorhernandez.struts2.pra.domain.Product;
import me.victorhernandez.struts2.pra.service.ProductService;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddProductAction extends ActionSupport implements
		ModelDriven<Product> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6727629495086452702L;

	Product newProduct = new Product();
	@Autowired
	@Qualifier(value = "productService")
	private ProductService productService;
	
	private String errorMessage;
	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public Product getModel() {
		return newProduct;
	}

	public String getErrorMessage() {
		return errorMessage;
	}


	@Override
	public String execute()  {
		try {
			productService.persistProduct(newProduct);
			return SUCCESS;
		} catch (Exception ex) {
			errorMessage = ex.getMessage();
			return ERROR;
		} 
	}
	
	public String modify(){
		productService.modifyProduct(newProduct);
		return SUCCESS;
	}
	
	public String delete(){
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		Long id = (Long) request.getAttribute("id");
		productService.deleteProduct(id);
		return SUCCESS;
	}
}
