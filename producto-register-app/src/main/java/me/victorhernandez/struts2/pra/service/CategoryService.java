package me.victorhernandez.struts2.pra.service;

import java.util.List;

import me.victorhernandez.struts2.pra.domain.Category;

public interface CategoryService {

	public Category getCategoryById(Long id);
	public List<Category> getAllCategories();
	public List<Category> getAllWithProducts();
	public Category getCategoryByName(String name);
	public void saveCategory(Category category);
	public void modifyCategory(Category category);
	public void deleteCategory(Category category);
}
