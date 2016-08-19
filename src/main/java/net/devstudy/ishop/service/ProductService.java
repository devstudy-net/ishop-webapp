package net.devstudy.ishop.service;

import java.util.List;

import net.devstudy.ishop.entity.Category;
import net.devstudy.ishop.entity.Producer;
import net.devstudy.ishop.entity.Product;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public interface ProductService {

	List<Product> listAllProducts(int page, int limit);
	
	List<Product> listProductsByCategory(String categoryUrl, int page, int limit);
	
	List<Category> listAllCategories();
	
	List<Producer> listAllProducers();
}
