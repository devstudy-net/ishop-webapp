package net.devstudy.ishop.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import net.devstudy.ishop.entity.Product;
import net.devstudy.ishop.exception.InternalServerErrorException;
import net.devstudy.ishop.form.ProductForm;
import net.devstudy.ishop.jdbc.JDBCUtils;
import net.devstudy.ishop.jdbc.ResultSetHandler;
import net.devstudy.ishop.jdbc.ResultSetHandlerFactory;
import net.devstudy.ishop.model.ShoppingCart;
import net.devstudy.ishop.service.OrderService;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
class OrderServiceImpl implements OrderService {
	private static final ResultSetHandler<Product> productResultSetHandler = 
			ResultSetHandlerFactory.getSingleResultSetHandler(ResultSetHandlerFactory.PRODUCT_RESULT_SET_HANDLER);
	
	private final DataSource dataSource;
	
	public OrderServiceImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	@Override
	public void addProductToShoppingCart(ProductForm productForm, ShoppingCart shoppingCart) {
		try (Connection c = dataSource.getConnection()) {
			Product product = JDBCUtils.select(c, "select p.*, c.name as category, pr.name as producer from product p, producer pr, category c "
					+ "where c.id=p.id_category and pr.id=p.id_producer and p.id=?", productResultSetHandler, productForm.getIdProduct());
			if(product == null) {
				throw new InternalServerErrorException("Product not found by id="+productForm.getIdProduct());
			}
			shoppingCart.addProduct(product, productForm.getCount());
		} catch (SQLException e) {
			throw new InternalServerErrorException("Can't execute sql query: " + e.getMessage(), e);
		}
	}
}
