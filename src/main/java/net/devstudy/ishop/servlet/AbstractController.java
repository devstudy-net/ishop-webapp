package net.devstudy.ishop.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import net.devstudy.ishop.service.BusinessService;
import net.devstudy.ishop.service.ServiceManager;

public abstract class AbstractController extends HttpServlet {
	private static final long serialVersionUID = -2031074947573473708L;

	private BusinessService businessService;

	@Override
	public final void init() throws ServletException {
		businessService = ServiceManager.getInstance(getServletContext()).getBusinessService();
	}
	
	public final BusinessService getBusinessService() {
		return businessService;
	}
}
