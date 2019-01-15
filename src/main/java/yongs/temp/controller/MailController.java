package yongs.temp.controller;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MailController {
	private static final Logger logger = LoggerFactory.getLogger(MailController.class);

	@Autowired
	private JavaMailSender mailSender;

	@RequestMapping("/mail/mailForm")
	public String mailForm() {
		return "mail/mailForm";
	}

	@RequestMapping("/mail/mailSend")
	public String mailSend(HttpServletRequest request, Model model) throws Exception {

		// String frommail = "niptest21@gmail.com";
		String frommail = "yongschoi@lgcns.com";
		String tomail = request.getParameter("tomail");   // 받는 사람 이메일
		String title = request.getParameter("title");     // 보내는 사람 이메일
		String content = request.getParameter("content"); // 보내는 사람 이메일

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

		messageHelper.setFrom(frommail); // 보내는사람 생략하거나 하면 정상작동을 안함
		messageHelper.setTo(tomail);     // 받는사람 이메일
		messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
		messageHelper.setText(content);  // 메일 내용

		mailSender.send(message);

		model.addAttribute("out", "메일이 발송되었습니다.");

		return "result";
	}
}