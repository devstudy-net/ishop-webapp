package net.devstudy.ishop.service;

import net.devstudy.ishop.form.ProductForm;
import net.devstudy.ishop.model.ShoppingCart;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public interface OrderService {

	void addProductToShoppingCart(ProductForm productForm, ShoppingCart shoppingCart);
}
