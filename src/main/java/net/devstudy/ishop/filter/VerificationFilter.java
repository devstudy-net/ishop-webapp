package net.devstudy.ishop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import net.devstudy.ishop.service.BusinessService;
import net.devstudy.ishop.service.ServiceManager;

@WebFilter("/*")
public class VerificationFilter implements Filter {
	private BusinessService businessService;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		businessService = ServiceManager.getInstance(filterConfig.getServletContext()).getBusinessService();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		businessService.doSomething();
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}
}
