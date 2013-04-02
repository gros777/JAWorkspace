package me.victorhernandez.struts2.pra.service.jpa;

import java.util.Date;
import java.util.List;

import me.victorhernandez.struts2.pra.dao.ProductDao;
import me.victorhernandez.struts2.pra.domanin.Product;
import me.victorhernandez.struts2.pra.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service(value="productService")
public class ProductServiceJpa implements ProductService {

	
	@Autowired
	@Qualifier(value="productRepository")
	private ProductDao productDao;
	
	public Product getProduct(Long id) {
		return productDao.get(id);
	}

	public List<Product> getAllProducts() {
		return productDao.getAll();
	}
	@Transactional(
		    propagation = Propagation.REQUIRED,
		    isolation = Isolation.DEFAULT,
		    readOnly = false)
	public void persistProduct(Product object) throws Exception {
		Assert.notNull(object, "The product cannot be null");
		Assert.hasText(object.getProductName(), "The product's name has to be filled");
		Assert.state(object.getAvailables() > 0, "The existence can't be negative");
		productDao.save(object);
		
	}
	@Transactional(
		    propagation = Propagation.REQUIRED,
		    isolation = Isolation.DEFAULT,
		    readOnly = false)
	public void deleteProduct(Product object) {
		productDao.delete(object);
	}

	public List<Product> getProductsByCaducity(Date caducity) {
		Assert.notNull(caducity, "The date can't be null");
		return productDao.getProductsByCaducity(caducity);
	}

	public Product getProductByName(String name) {
		return productDao.getProductByName(name);
	}

	public List<Product> getProductsByMark(String mark) {
		return productDao.getProductsByMark(mark);
	}

	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

}
