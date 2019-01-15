package yongs.temp.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IdleTestController {
	private static final Logger logger = LoggerFactory.getLogger(IdleTestController.class);

	@RequestMapping("/admin/idleForm")
	public String idleForm() {
		return "admin/idleForm";
	}

	@RequestMapping("/admin/idleTest")
	public String idleTest(HttpServletRequest req, Model model) throws Exception {
		String secTime = req.getParameter("secTime");
		logger.info("set time [ " + secTime + " ] sec");
		
		int timer = 0;
		while(true) {
			Thread.sleep(10*1000);
			timer = timer + 10;
			logger.info("elapse time ::: " + timer);			
			if(timer==new Integer(secTime)) {
				logger.info("Idle Test Complete.");
				break; 
			}
		}	
		model.addAttribute("out", "완료");

		return "result";
	}
}