/**
 * 
 */
package me.victorhernandez.struts2.pra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.victorhernandez.struts2.pra.dao.CategoryDao;
import me.victorhernandez.struts2.pra.domain.Category;

/**
 * @author victor
 *
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	@Qualifier("categoryRepository")
	CategoryDao categoryRepository;
	
	/* (non-Javadoc)
	 * @see me.victorhernandez.struts2.pra.service.CategoryService#getCategoryById(java.lang.Long)
	 */
	public Category getCategoryById(Long id) {
		return categoryRepository.get(id);
	}

	/* (non-Javadoc)
	 * @see me.victorhernandez.struts2.pra.service.CategoryService#getAllCategories()
	 */
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryRepository.getAll();
	}

	/* (non-Javadoc)
	 * @see me.victorhernandez.struts2.pra.service.CategoryService#getAllWithProducts()
	 */
	public List<Category> getAllWithProducts() {
		// TODO Auto-generated method stub
		return categoryRepository.getAllWithProducts();
	}

	/* (non-Javadoc)
	 * @see me.victorhernandez.struts2.pra.service.CategoryService#getCategoryByName(java.lang.String)
	 */
	public Category getCategoryByName(String name) {
		// TODO Auto-generated method stub
		return categoryRepository.getCategoryByName(name);
	}

	@Transactional(readOnly=false)
	public void saveCategory(Category category) {
		
		categoryRepository.save(category);
	}

	@Transactional(readOnly=false)
	public void deleteCategory(Category category) {
		categoryRepository.delete(category);
	}
	@Transactional(readOnly=false)
	public void modifyCategory(Category category) {
		categoryRepository.modify(category);
	}

}
