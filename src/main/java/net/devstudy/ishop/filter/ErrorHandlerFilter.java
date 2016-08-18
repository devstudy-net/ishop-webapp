package net.devstudy.ishop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.devstudy.ishop.util.RoutingUtils;

@WebFilter("/*")
public class ErrorHandlerFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		try {
			chain.doFilter(req, resp);
		} catch (Throwable th) {
			String requestUrl = ((HttpServletRequest)req).getRequestURI();
			// LOGGER.error("Request " + requestUrl + " failed: " + th.getMessage(), th);
			RoutingUtils.forwardToPage("error.jsp", ((HttpServletRequest)req), ((HttpServletResponse)resp));
		}
	}

	@Override
	public void destroy() {
	}
}
