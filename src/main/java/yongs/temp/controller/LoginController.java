package yongs.temp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import yongs.temp.dao.UserDao;
import yongs.temp.exception.NoIdentityException;
import yongs.temp.vo.User;
 
@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    
    @Autowired
    private UserDao userDao;
     
    @RequestMapping("/loginPage")
    public String prelogin() {
        return "loginPage";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest req, Model model) throws Exception {  	
    	String username = req.getParameter("username");
    	String password = req.getParameter("password");
 
    	logger.debug("username=> " + username);
    	logger.debug("password=> " + password);
    	
    	User user = userDao.findUser(username);
    	
    	if(!user.getPassword().equals(password)) {
    		throw new NoIdentityException();
    	}
    	    	
    	HttpSession session = req.getSession(true);
    	session.setAttribute("SESSION_USER", user);
    	
    	// 세션 time out 적용 최우선순위(초)
    	// session.setMaxInactiveInterval(10);

    	logger.debug("=========================>>> Login Success !!!");
    	model.addAttribute("out", username);
    	
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest req, Model model) throws Exception {  	
    	String username = req.getParameter("username");
    	String password = req.getParameter("password");
 
    	logger.debug("username=> " + username);
    	logger.debug("password=> " + password);
    	
    	HttpSession session = req.getSession(false);
    	
    	////////////////////////////////////////////////////////////////////////////////////
    	if(session != null) {
    		session.removeAttribute("SESSION_USER");
    		session.invalidate();
    	}
    	model.addAttribute("out", "정상적으로 로그아웃 되었습니다.");
    	
        return "result";
    }
    
	@ExceptionHandler({EmptyResultDataAccessException.class}) 
	public String userError(HttpServletRequest req, Model model) { 
		// Nothing to do. Returns the logical view name of an error page, passed to 
		// the view-resolver(s) in usual way. 
		// Note that the exception is _not_ available to this view (it is not added to 
		// the model) but see "Extending ExceptionHandlerExceptionResolver" below. 
		String username = req.getParameter("username");
		model.addAttribute("out", username+"는 존재하지 않는 사용자입니다.");
		return "loginPage"; 
	} 
	
	@ExceptionHandler({NoIdentityException.class}) 
	public String noIdentity(Model model) { 
		// Nothing to do. Returns the logical view name of an error page, passed to 
		// the view-resolver(s) in usual way. 
		// Note that the exception is _not_ available to this view (it is not added to 
		// the model) but see "Extending ExceptionHandlerExceptionResolver" below. 
		model.addAttribute("out", "Password가 틀립니다.");
		return "loginPage"; 
	} 
}