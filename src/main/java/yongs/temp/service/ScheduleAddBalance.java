package yongs.temp.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import yongs.temp.biz.MyBank;

public class ScheduleAddBalance extends QuartzJobBean{
	private static final Logger logger = LoggerFactory.getLogger(ScheduleAddBalance.class);
	
	private MyBank myBank;
	private String accountNo;
	private long balance;
	
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
    	 myBank.addBalance(accountNo, balance);
    	 Date today = new Date();
    	 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	 logger.debug(">>>>> " + dateFormat.format(today) + " <<<<<");
    }
    
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }
    public void setBalance(long balance) {
        this.balance = balance;
    }
    public void setMyBank(MyBank myBank) {
        this.myBank = myBank;
    }  
}