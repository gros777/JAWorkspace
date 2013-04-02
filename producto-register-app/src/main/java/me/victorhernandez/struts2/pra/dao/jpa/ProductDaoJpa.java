package me.victorhernandez.struts2.pra.dao.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import me.victorhernandez.struts2.pra.dao.ProductDao;
import me.victorhernandez.struts2.pra.domain.Product;
@Repository(value="productRepository")
public class ProductDaoJpa extends GenericDaoJpa<Product> implements
		ProductDao {

	public ProductDaoJpa() {
		super(Product.class);
	}

	@Transactional(readOnly = true)
	public List<Product> getProductsByCaducity(Date caducity) {
		List<Product> results = null;
	    Query query = entityManager.createQuery(
	      "from Product as p where p.goodThough <= :caducity"
	    );
	    query.setParameter("caducity", caducity);
	    results = query.getResultList();
	    if (results == null || results.size() <= 0){
	    	throw new EntityNotFoundException(caducity+ " not found");
	    }else {
	        return results;
	    }
	}

	@Transactional(readOnly = true)
	public Product getProductByName(String name) {
		List<Product> results = null;
	    Query query = entityManager.createQuery(
	      "from Product as p where p.productName = :name"
	    );
	    query.setParameter("name", name);
	    results = query.getResultList();
	    if (results == null || results.size() <= 0){
	    	throw new EntityNotFoundException(name+ " not found");
	    }else {
	        return results.get(0);
	    }
	}
	@Transactional(readOnly = true)
	public List<Product> getProductsByMark(String mark) {
		List<Product> results = null;
	    Query query = entityManager.createQuery(
	      "from Product as p where p.mark= :mark"
	    );
	    query.setParameter("mark", mark);
	    results = query.getResultList();
	    if (results == null || results.size() <= 0){
	    	throw new EntityNotFoundException(mark+ " not found");
	    }else {
	        return results;
	    }
	}

}
