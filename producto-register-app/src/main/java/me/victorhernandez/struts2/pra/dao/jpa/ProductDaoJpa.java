package me.victorhernandez.struts2.pra.dao.jpa;

import java.util.Date;
import java.util.List;


import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import me.victorhernandez.struts2.pra.dao.ProductDao;
import me.victorhernandez.struts2.pra.domain.Product;
import me.victorhernandez.struts2.pra.exceptions.EntityNotFoundException;
@Repository(value="productRepository")
public class ProductDaoJpa extends GenericDaoJpa<Product> implements
		ProductDao {

	public ProductDaoJpa() {
		super(Product.class);
	}

	@Transactional(readOnly = true)
	public List<Product> getProductsByCaducity(Date caducity) throws EntityNotFoundException {
		List<Product> results = null;
	    Query query = sessionFactory.getCurrentSession().createQuery(
	      "from Product as p where p.goodThough <= :caducity"
	    );
	    query.setParameter("caducity", caducity);
	    results = query.list();
	    if (results == null || results.size() <= 0){
	    	throw new EntityNotFoundException(caducity+ " not found");
	    }else {
	        return results;
	    }
	}

	@Transactional(readOnly = true)
	public Product getProductByName(String name) throws EntityNotFoundException {
		List<Product> results = null;
	    Query query = sessionFactory.getCurrentSession().createQuery(
	      "from Product as p where p.productName = :name"
	    );
	    query.setParameter("name", name);
	    results = query.list();
	    if (results == null || results.size() <= 0){
	    	throw new EntityNotFoundException(name+ " not found");
	    }else {
	        return results.get(0);
	    }
	}
	@Transactional(readOnly = true)
	public List<Product> getProductsByMark(String mark) throws EntityNotFoundException {
		List<Product> results = null;
	    Query query = sessionFactory.getCurrentSession().createQuery(
	      "from Product as p where p.mark= :mark"
	    );
	    query.setParameter("mark", mark);
	    results = query.list();
	    if (results == null || results.size() <= 0){
	    	throw new EntityNotFoundException(mark+ " not found");
	    }else {
	        return results;
	    }
	}
	
	public void modify(Product product) {
		Product originalProduct = (Product) sessionFactory.getCurrentSession().get(Product.class, product.getId());
		originalProduct.copyFrom(product);
	}
	
	public void deleteProduct(Long id) {
		Product productToDelete = (Product) sessionFactory.getCurrentSession().get(Product.class, id);
		super.delete(productToDelete);
	}

}
