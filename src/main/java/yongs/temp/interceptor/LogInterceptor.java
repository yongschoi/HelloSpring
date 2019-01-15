package yongs.temp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LogInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = LoggerFactory.getLogger(LogInterceptor.class);
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        long startTime = System.currentTimeMillis();
        logger.info("\n-------- LoginInterceptor.preHandle --- ");
        logger.info("Request URL: " + request.getRequestURL());
        logger.info("Start Time: " + System.currentTimeMillis());
 
        request.setAttribute("startTime", startTime);
        
        return true;
    }
 
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
    	logger.info("\n-------- LoginInterceptor.postHandle --- ");
    	logger.info("Request URL: " + request.getRequestURL());
 
        // You can add attributes in the modelAndView
        // and use that in the view page
    }
 
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    	logger.info("\n-------- LoginInterceptor.afterCompletion --- ");
 
        long startTime = (Long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();

        logger.info(request.getRequestURL() + " : " + (endTime - startTime) + "ms");
    }   
}