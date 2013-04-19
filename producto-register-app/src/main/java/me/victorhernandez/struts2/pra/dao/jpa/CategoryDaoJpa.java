/**
 * 
 */
package me.victorhernandez.struts2.pra.dao.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import me.victorhernandez.struts2.pra.dao.CategoryDao;
import me.victorhernandez.struts2.pra.domain.Category;

/**
 * @author victor
 * 
 */
@Repository("categoryRepository")
public class CategoryDaoJpa extends GenericDaoJpa<Category> implements
		CategoryDao {

	public CategoryDaoJpa() {
		super(Category.class);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Category> getAllWithProducts() {

		return sessionFactory.getCurrentSession()
				.getNamedQuery("Category.findCategoryWithProduct").list();
	}

	@Transactional(readOnly = true)
	public Category getCategoryByName(String name) {
		return (Category) sessionFactory.getCurrentSession()
				.createQuery("from Category c where c.categoryName = :name")
				.setParameter("name", name).uniqueResult();
	}

	public void modify(Category category) {
		Category original = (Category) sessionFactory.getCurrentSession().merge(category);
		save(original);
	}

}
