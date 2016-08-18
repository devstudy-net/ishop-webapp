package net.devstudy.ishop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.devstudy.ishop.util.RoutingUtils;

@WebServlet("/products")
public class AllProductsController extends AbstractController {
	private static final long serialVersionUID = -4385792519039493271L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*List<?> products = getBusinessService().getProducts();
		req.setAttribute("products", products);*/
		RoutingUtils.forwardToPage("products.jsp", req, resp);
	}
}
