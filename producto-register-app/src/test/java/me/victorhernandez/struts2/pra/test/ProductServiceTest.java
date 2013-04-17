/**
 * 
 */
package me.victorhernandez.struts2.pra.test;

import java.util.Iterator;
import java.util.List;

import me.victorhernandez.struts2.pra.domain.Product;
import me.victorhernandez.struts2.pra.exceptions.EntityNotFoundException;
import me.victorhernandez.struts2.pra.service.ProductService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author victor
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/spring/spring-test-beans.xml")
public class ProductServiceTest {

	@Autowired
	@Qualifier(value="productService")
	ProductService productService;
	
	@Autowired
	@Qualifier(value="product2")
	Product beanProduct1;
	
	int dbRowsTotal = 12;
	@Test
	public void injectionTest(){
		Assert.assertNotNull("ProductService not Autowired correctly", productService );
	}
	
	@Test
	public void getProductTest() throws EntityNotFoundException{
		List<Product> products = productService.getAllProducts();
		Assert.assertNotNull(products);
		Assert.assertTrue("Wrong Object count", products.size() == dbRowsTotal);
		for (Iterator iterator = products.iterator(); iterator.hasNext();) {
			Product product = (Product) iterator.next();
			System.out.println(product.toString());
			
		}
		
		Assert.assertNotNull("Can't get object by name", productService.getProductByName("Guitarra Clasica"));
		Product product1 = productService.getProductByName("Guitarra Clasica");
		
		
		Assert.assertNotNull("Can't get object by Mark", productService.getProductsByMark("Fama"));
		Product product2 =  productService.getProductsByMark("Fama").get(1);
		
		Assert.assertNotNull("Can't get object by id", productService.getProduct(new Long(8)));
		Product product3 = productService.getProduct(new Long(8));
		
		System.out.println("Producto por nombre:" + product1.toString());
		System.out.println("Producto por marca:" + product2.toString());
		System.out.println("Producto por id:" + product3.toString());
		
	}
	
	
	@Test
	public void insertProductTest() throws Exception {
		Assert.assertNotNull("Problems autowiring product1", beanProduct1);
//		productService.persistProduct(beanProduct1);
	}
	
	@Test
	public void modifyProductTest(){
		Long id = new Long(11);
		Product product3 = productService.getProduct(id);
		product3.setMark("La Italiana");
		productService.modifyProduct(product3);
		Assert.assertTrue("Fail updating product", productService.getProduct(id).getMark().equals("La Italiana"));
	}
	@Test
	public void deleteProductTest(){
		productService.deleteProduct(new Long(11));
		try {
			Assert.assertNull(productService.getProductsByMark("La Italiana"));
		} catch (EntityNotFoundException e) {
			Assert.assertTrue(true);
		}
	}
}
