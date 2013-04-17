package me.victorhernandez.struts2.pra.service;

import java.util.Date;
import java.util.List;

import me.victorhernandez.struts2.pra.domain.Product;
import me.victorhernandez.struts2.pra.exceptions.EntityNotFoundException;

public interface ProductService {
	
	public Product getProduct(Long id);
    public List<Product> getAllProducts();
    public void persistProduct(Product object) throws Exception;
    public void modifyProduct(Product object);
    public void deleteProduct(Long id);
	public List<Product> getProductsByCaducity(Date caducity) throws EntityNotFoundException;
	public Product getProductByName(String name) throws EntityNotFoundException;
	public List<Product> getProductsByMark(String mark) throws EntityNotFoundException;
}
