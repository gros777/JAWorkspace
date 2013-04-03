package me.victorhernandez.struts2.pra.dao;

import java.util.Date;
import java.util.List;

import me.victorhernandez.struts2.pra.domain.Product;

public interface ProductDao extends GenericDao<Product> {

	public List<Product> getProductsByCaducity(Date caducity);
	public Product getProductByName(String name);
	public List<Product> getProductsByMark(String mark);
	public void modify(Product product);
}
