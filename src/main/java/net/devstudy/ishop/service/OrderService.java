package net.devstudy.ishop.service;

import net.devstudy.ishop.form.ProductForm;
import net.devstudy.ishop.model.CurrentAccount;
import net.devstudy.ishop.model.ShoppingCart;
import net.devstudy.ishop.model.SocialAccount;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public interface OrderService {

	void addProductToShoppingCart(ProductForm productForm, ShoppingCart shoppingCart);
	
	void removeProductFromShoppingCart(ProductForm form, ShoppingCart shoppingCart);
	
	String serializeShoppingCart(ShoppingCart shoppingCart);
	
	ShoppingCart deserializeShoppingCart(String string);
	
	CurrentAccount authentificate(SocialAccount socialAccount);
}
