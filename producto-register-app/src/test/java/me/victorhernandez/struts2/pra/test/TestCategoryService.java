package me.victorhernandez.struts2.pra.test;

import me.victorhernandez.struts2.pra.domain.Category;
import me.victorhernandez.struts2.pra.domain.Product;
import me.victorhernandez.struts2.pra.exceptions.EntityNotFoundException;
import me.victorhernandez.struts2.pra.service.CategoryService;
import me.victorhernandez.struts2.pra.service.ProductService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/spring/spring-test-beans.xml")
public class TestCategoryService {
	
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	@Autowired
	@Qualifier("product2")
	Product product1;
	
	public void saveCategoryTest(){
		Category newCategory = new Category();
		newCategory.setCategoryName("Lacteos");
		categoryService.saveCategory(newCategory);
		Assert.assertNotNull(categoryService.getAllCategories().get(0));
		Assert.assertEquals(1, categoryService.getAllCategories().size());
	}

	@Test
	public void modifyCategory() throws EntityNotFoundException{
//		Product leche = productService.getProductByName("Leche entera");
//		Product yougurt = productService.getProductByName("Yougurt");
		
		Category toModify = categoryService.getCategoryById(new Long(1));
//		leche.setCategory(toModify);
//		yougurt.setCategory(toModify);
//		productService.modifyProduct(yougurt);
//		productService.modifyProduct(leche);
		
		
		int initProducts= categoryService.getAllWithProducts().get(0).getProducts().size();
		toModify = categoryService.getAllWithProducts().get(0);
		toModify.addProductToCategory(product1);
		categoryService.modifyCategory(toModify);
		Assert.assertEquals(initProducts + 1, categoryService.getAllWithProducts().get(0).getProducts().size());
		
		
	}
}
