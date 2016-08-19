package net.devstudy.ishop.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import net.devstudy.ishop.form.ProductForm;
import net.devstudy.ishop.form.SearchForm;
import net.devstudy.ishop.service.OrderService;
import net.devstudy.ishop.service.ProductService;
import net.devstudy.ishop.service.impl.ServiceManager;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public abstract class AbstractController extends HttpServlet {
	private static final long serialVersionUID = -2031074947573473708L;

	private ProductService productService;
	private OrderService orderService;

	@Override
	public final void init() throws ServletException {
		productService = ServiceManager.getInstance(getServletContext()).getProductService();
		orderService = ServiceManager.getInstance(getServletContext()).getOrderService();
	}

	public final ProductService getProductService() {
		return productService;
	}

	public final OrderService getOrderService() {
		return orderService;
	}
	
	public final int getPageCount(int totalCount, int itemsPerPage) {
		int res = totalCount / itemsPerPage;
		if(res * itemsPerPage != totalCount) {
			res++;
		}
		return res;
	}
	
	public final int getPage(HttpServletRequest request) {
		try {
			return Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {
			return 1;
		}
	}
	
	public final SearchForm createSearchForm(HttpServletRequest request) {
		return new SearchForm(
				request.getParameter("query"), 
				request.getParameterValues("category"), 
				request.getParameterValues("producer"));
	}
	
	public final ProductForm createProductForm(HttpServletRequest request) {
		return new ProductForm(
				Integer.parseInt(request.getParameter("idProduct")),
				Integer.parseInt(request.getParameter("count")));
	}
}
