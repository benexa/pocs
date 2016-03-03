package custom.rest;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ConfigurableApplicationContext;

import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.spi.container.WebApplication;
import com.sun.jersey.spi.container.servlet.WebConfig;
import com.sun.jersey.spi.spring.container.servlet.SpringServlet;



public class CustomRest extends SpringServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected ConfigurableApplicationContext getChildContext(String contextConfigLocation) {
		// TODO Auto-generated method stub
		return super.getChildContext(contextConfigLocation);
	}

	@Override
	protected ConfigurableApplicationContext getContext() {
		// TODO Auto-generated method stub
		return super.getContext();
	}

	@Override
	protected ConfigurableApplicationContext getDefaultContext() {
		// TODO Auto-generated method stub
		return super.getDefaultContext();
	}

	@Override
	protected ResourceConfig getDefaultResourceConfig(Map<String, Object> props, WebConfig webConfig)
			throws ServletException {
		// TODO Auto-generated method stub
		return super.getDefaultResourceConfig(props, webConfig);
	}

	@Override
	protected void initiate(ResourceConfig arg0, WebApplication arg1) {
		// TODO Auto-generated method stub
		super.initiate(arg0, arg1);
	}



	
}
