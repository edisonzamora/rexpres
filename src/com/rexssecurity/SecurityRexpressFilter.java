package com.rexssecurity;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.config.ConfigApp;
import com.rexpress.beans.UserBean;

public class SecurityRexpressFilter implements Filter {

	
	private static final Logger logger = LogManager.getLogger(SecurityRexpressFilter.class);
	
	private ServletContext context;

	@Autowired
	private ConfigApp configap;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();
        logger.debug("init "+context.getContextPath());
        logger.debug("init "+ context.getServerInfo());
        logger.debug("init "+ context.getMajorVersion());
        logger.debug("init "+ context.getMinorVersion());
        logger.debug("init "+ context.getServletContextName());
        logger.debug("init "+filterConfig.getFilterName());
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session=req.getSession();

		if(session!=null){
			logger.info("session no  null");
			logger.info("sessionID=)"+session.getId());
		}
		UserBean Userbean = (UserBean) req.getSession(false).getAttribute("userbean");
		if (Userbean != null) {
			String uri = req.getRequestURI();
			session.setMaxInactiveInterval(30000);
			logger.debug("Requested Resource::URI:: " + uri);
			 Enumeration<String> headers = req.getHeaderNames();
			 while (headers.hasMoreElements()) {
			 String key = headers.nextElement();
			 logger.debug(key + "<-- " + req.getHeader(key));
			 }
			RequestDispatcher rsdpc = null;
			rsdpc = req.getRequestDispatcher("homeView.xhtml");
			rsdpc.forward(req, res);
		} else {
			String uri = req.getRequestURI();
			logger.debug("Requested Resource::URI:: " + uri);
			 Enumeration<String> headers = req.getHeaderNames();
			 while (headers.hasMoreElements()) {
			 String key = headers.nextElement();
			 logger.debug(key + "<-- " + req.getHeader(key));
			 }
			res.sendRedirect("/Rexpress/view/loginView.xhtml");
			// RequestDispatcher rsdpc = null;
			// rsdpc = req.getRequestDispatcher("homeView.xhtml");
			// rsdpc.forward(req, res);
		}
	}

	@Override
	public void destroy() {
		logger.debug("---------destroy Filter--------------");

	}

}
