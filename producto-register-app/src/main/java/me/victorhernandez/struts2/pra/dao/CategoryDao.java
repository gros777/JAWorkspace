package me.victorhernandez.struts2.pra.dao;

import java.util.List;

import me.victorhernandez.struts2.pra.domain.Category;

public interface CategoryDao extends GenericDao<Category> {

	public List<Category> getAllWithProducts();
	public Category getCategoryByName(String name);
	public void modify(Category category);
}
