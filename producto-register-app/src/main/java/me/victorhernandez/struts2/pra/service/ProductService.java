package me.victorhernandez.struts2.pra.service;

import java.util.Date;
import java.util.List;

import me.victorhernandez.struts2.pra.domain.Product;

public interface ProductService {
	
	public Product getProduct(Long id);
    public List<Product> getAllProducts();
    public void persistProduct(Product object) throws Exception;
    public void modifyProduct(Product object);
    public void deleteProduct(Product object);
	public List<Product> getProductsByCaducity(Date caducity);
	public Product getProductByName(String name);
	public List<Product> getProductsByMark(String mark);
}
