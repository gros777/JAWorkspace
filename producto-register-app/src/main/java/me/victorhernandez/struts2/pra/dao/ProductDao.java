package me.victorhernandez.struts2.pra.dao;

import java.util.Date;
import java.util.List;

import me.victorhernandez.struts2.pra.domain.Product;
import me.victorhernandez.struts2.pra.exceptions.EntityNotFoundException;

public interface ProductDao extends GenericDao<Product> {

	public List<Product> getProductsByCaducity(Date caducity) throws EntityNotFoundException;
	public Product getProductByName(String name) throws EntityNotFoundException;
	public List<Product> getProductsByMark(String mark) throws EntityNotFoundException;
	public void modify(Product product);
	public void deleteProduct(Long id); 
}
