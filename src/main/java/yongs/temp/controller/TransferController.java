package yongs.temp.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import yongs.temp.biz.MyBank;
import yongs.temp.biz.Transfer;
import yongs.temp.exception.InsufficientException;
import yongs.temp.vo.Account;
import yongs.temp.vo.User;
 
@Controller
public class TransferController {
    private static final Logger logger = LoggerFactory.getLogger(TransferController.class);
    
    @Autowired
    private Transfer transfer;
    @Autowired
    private MyBank mybank;

    @RequestMapping("/selectAccount.transfer")
    public String selectAccount(HttpServletRequest req, Model model) {
    	logger.info("TransferController.selectAccount");
    	User user =  (User) req.getSession().getAttribute("SESSION_USER");
    	Account account = mybank.selectAccount(user.getUserName());
    	
    	model.addAttribute("account", account);     
        return "transfer/selectAccountToCommit";
    }
    
    @RequestMapping("/commit.transfer") 
    public String commit(HttpServletRequest req, Model model) throws Exception {
    	String sourceNo = req.getParameter("sourceNo");
    	String targetNo = req.getParameter("targetNo");
    	int tmoney = Integer.parseInt(req.getParameter("tmoney"));   	     

    	// 이체 실행
    	transfer.commit(sourceNo, tmoney, targetNo); 
    	// 이체내역 저장
    	transfer.insertHistory(sourceNo, tmoney, targetNo);
    	
    	Account account = mybank.selectAccountByNo(sourceNo);
    	model.addAttribute("account", account);
    	
    	return "transfer/selectAccount";
    }
    
	@ExceptionHandler({InsufficientException.class})
	public String Insufficient(Model model) { 
		// Nothing to do. Returns the logical view name of an error page, passed to 
		// the view-resolver(s) in usual way. 
		// Note that the exception is _not_ available to this view (it is not added to 
		// the model) but see "Extending ExceptionHandlerExceptionResolver" below. 
		model.addAttribute("out", "잔액이 부족합니다.");
		return "result"; 
	}
}