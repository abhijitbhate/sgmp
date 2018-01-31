package com.cme.oscar.reports.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class GlobalInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(GlobalInterceptor.class.getCanonicalName());
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
		long start = System.currentTimeMillis();
		Date s = new Date(start);
		
		request.setAttribute("RequestReceivedDate", s);
		
		logger.info("GlobalInterceptor: preHandle: Request Method: {} Requested Resource: {} Time Request Received: {}",request.getMethod(), request.getPathInfo(), sdf.format(s));
		
		return true;
	}
	

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		
		long end = System.currentTimeMillis();
		Date e = new Date(end);
		
		Date s = (Date)request.getAttribute("RequestReceivedDate");
		long start = s.getTime();
		
		long pass = (end-start);
		
		logger.info("GlobalInterceptor: postHandle: Request Method: {} Requested Resource: {} Time Request Finished: {}",request.getMethod(), request.getPathInfo(), sdf.format(e));
		logger.info("GlobalInterceptor: postHandle: Request Finished: starting at: "+sdf.format(s)+" ending at: "+sdf.format(e)+" Total time taken: "+pass+" ms");
	}

}
