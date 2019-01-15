package yongs.temp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import yongs.temp.biz.MyBank;
import yongs.temp.dao.UserDao;
import yongs.temp.dao.UserRoleDao;
import yongs.temp.vo.User;

@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserRoleDao userRoleDao;

    @Autowired
    private MyBank mybank;
    
	@RequestMapping("/user/createPage")
	public String createPage() {

		return "user/createPage";
	}

	@RequestMapping("/user/create")
	public String create(HttpServletRequest req, Model model) throws Exception {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		int enabled = Integer.parseInt(req.getParameter("enabled"));
		logger.debug(username + " : " + password + " : " + enabled);

		User user = new User(username, password, enabled);
		userDao.createUser(user);
		
		// 최초 가입축하금 지급
		mybank.createAccount(user.getUserName());
		
		List<String> roles = new ArrayList<String>();
		roles.add("USER");
		userRoleDao.updateRole(username, roles);

		model.addAttribute("out", "정상적으로 등록되었습니다. 로그인하세요.");

		return "result";
	}

	@RequestMapping("/user/retrieve")
	public String retrieve(HttpServletRequest req, Model model, @RequestParam("userNameParam") String userName)
			throws Exception {

		User user = userDao.findUser(userName);
		logger.debug("userRoles size : " + user.getUserRoles().size());
		model.addAttribute("user", user);

		return "user/userInfo";
	}
}