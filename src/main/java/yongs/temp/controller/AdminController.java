package yongs.temp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import yongs.temp.dao.UserDao;
import yongs.temp.dao.UserRoleDao;
import yongs.temp.vo.User;

@Controller
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
  
	@Autowired
	private UserDao userDao;

	@Autowired
	private UserRoleDao userRoleDao;
	
	@RequestMapping("/admin/updateAuthPage")
	public String updateAuthPage() {

		return "admin/updateAuthPage";
	}

	@RequestMapping("/admin/noAuthPage")
	public String noAuthPage(Model model) {
    	model.addAttribute("out", "접근권한이 없습니다.");
    	
        return "result";
	}
	

	@RequestMapping("/admin/retrieveUser")
	public String retrieveUser(HttpServletRequest req, Model model, @RequestParam("userNameParam") String username)
			throws Exception {
		User user = userDao.findUser(username);
		logger.debug("userRoles size : " + user.getUserRoles().size());
		model.addAttribute("user", user);

		return "admin/userRoleInfo_ajax";
	}

	@RequestMapping("/admin/updateUserRole")
	public String updateRole(HttpServletRequest req, Model model, @RequestParam(value="roles") List<String> roleArray) throws Exception {		
    	String username = req.getParameter("username");		
		userRoleDao.updateRole(username, roleArray);
		
		User user = userDao.findUser(username);
		logger.debug("userRoles size : " + user.getUserRoles().size());
		model.addAttribute("user", user);

		return "admin/userRoleInfo_ajax";
	}
	
	@ExceptionHandler({EmptyResultDataAccessException.class}) 
	public String userError(HttpServletRequest req, Model model) { 
		// Nothing to do. Returns the logical view name of an error page, passed to 
		// the view-resolver(s) in usual way. 
		// Note that the exception is _not_ available to this view (it is not added to 
		// the model) but see "Extending ExceptionHandlerExceptionResolver" below. 
		String username = req.getParameter("userNameParam");
		
		model.addAttribute("out", username + "는 존재하지 않는 사용자입니다.");
		return "result_ajax"; 
	} 
}