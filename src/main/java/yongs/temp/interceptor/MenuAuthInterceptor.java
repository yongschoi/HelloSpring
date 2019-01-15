package yongs.temp.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import yongs.temp.vo.User;

public class MenuAuthInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = LoggerFactory.getLogger(MenuAuthInterceptor.class);
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        logger.info("\n-------- MenuAuthInterceptor.preHandle --- ");
         
        HttpSession session = request.getSession();        
        User user = (User) session.getAttribute("SESSION_USER");
        List<String> userRole = user.getUserRoles();
                
        boolean authflag = false;
        
        if(userRole.contains("ADMIN") || userRole.contains("ROOT")) authflag = true;
        
        if(!authflag ) {
        	response.sendRedirect(request.getContextPath() + "/admin/noAuthPage");
        	return false;       	
        }

        return true;
    }
 
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
    	logger.info("\n-------- MenuAuthInterceptor.postHandle --- ");
 
        // You can add attributes in the modelAndView
        // and use that in the view page
    }
 
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    	logger.info("\n-------- MenuAuthInterceptor.afterCompletion --- ");
 
    }   
}