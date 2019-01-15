package yongs.temp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SessionTimeoutTestController {
	private static final Logger logger = LoggerFactory.getLogger(SessionTimeoutTestController.class);

	@RequestMapping("/admin/sessionTimeoutForm")
	public String sessionTimeoutForm() {
		return "admin/sessionTimeoutForm";
	}

	@RequestMapping("/admin/sessionTimeoutTestTest")
	public String sessionTimeoutTest(HttpServletRequest req, Model model) throws Exception {
		String secTime = req.getParameter("secTime");
		logger.info("set time [" + secTime + "] sec");
		
		HttpSession session = req.getSession(true);
    	
    	// 세션 time out 적용 최우선순위(초) ::: 개별 세션별로 적용됨.
    	session.setMaxInactiveInterval(new Integer(secTime));
    	
		model.addAttribute("out", "Session Timeout [" + secTime + "] 초 적용 (해당 세션만 적용됨)");

		return "result";
	}
}