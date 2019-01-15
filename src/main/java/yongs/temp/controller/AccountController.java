package yongs.temp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import yongs.temp.biz.MyBank;
import yongs.temp.vo.Account;
import yongs.temp.vo.AccountHistory;
import yongs.temp.vo.User;
 
@Controller
public class AccountController {
    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
     
    @Autowired
    private MyBank mybank;
    
    @RequestMapping("/account/history")
    public String accountHistory(HttpServletRequest req, Model model) throws Exception {
    	User user =  (User) req.getSession().getAttribute("SESSION_USER");
    	Account account = mybank.selectAccount(user.getUserName());
    	
    	List<AccountHistory> accountHistory = mybank.retrieveAccountHistory(account.getNo());
    	model.addAttribute("accountHistory", accountHistory);
        
        return "account/accountHistory";
    }
}