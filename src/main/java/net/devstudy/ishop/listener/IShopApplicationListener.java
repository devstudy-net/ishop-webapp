package net.devstudy.ishop.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import net.devstudy.ishop.service.ServiceManager;

@WebListener
public class IShopApplicationListener implements ServletContextListener {
	private ServiceManager serviceManager;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		serviceManager = ServiceManager.getInstance(sce.getServletContext());
		serviceManager.getBusinessService().doSomething();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		serviceManager.getBusinessService().doSomething();
		serviceManager.close();
	}
}
