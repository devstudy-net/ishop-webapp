package net.devstudy.ishop.servlet.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import net.devstudy.ishop.form.ProductForm;
import net.devstudy.ishop.model.ShoppingCart;
import net.devstudy.ishop.servlet.AbstractController;
import net.devstudy.ishop.util.RoutingUtils;
import net.devstudy.ishop.util.SessionUtils;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@WebServlet("/ajax/json/product/add")
public class AddProductController extends AbstractController{
	private static final long serialVersionUID = -3440773010973766553L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductForm productForm = createProductForm(req);
		ShoppingCart shoppingCart = SessionUtils.getCurrentShoppingCart(req);
		getOrderService().addProductToShoppingCart(productForm, shoppingCart);
		
		JSONObject r = new JSONObject();
		r.put("totalCount", shoppingCart.getTotalCount());
		r.put("totalCost", shoppingCart.getTotalCost());
		RoutingUtils.sendJSON(r, req, resp);
	}

}
