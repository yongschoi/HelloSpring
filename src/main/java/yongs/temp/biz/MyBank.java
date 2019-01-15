package yongs.temp.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yongs.temp.dao.MyBankDao;
import yongs.temp.vo.Account;
import yongs.temp.vo.AccountHistory;

@Service("myBank")
public class MyBank {
	private static final Logger logger = LoggerFactory.getLogger(MyBank.class);

	@Autowired
	private MyBankDao myBankDao;

	public Account selectAccount(String name) {
		return myBankDao.selectAccount(name);
	}
	
	public Account selectAccountByNo(String no) {
		return myBankDao.selectAccountByNo(no);
	}
	
	public void createAccount(String name) {
		String no = myBankDao.getNewNo();
		// 100,000 원 입금
		myBankDao.createAccount(no, 100000, name);
	}
	
	public List<AccountHistory> retrieveAccountHistory(String no) {
		return myBankDao.retrieveAccountHistory(no);
	}
	
	public void addBalance(String accountNo, long balance) {
		Account sourceAccount = myBankDao.selectAccountByNo(accountNo);
		long sourceBalance = 0;
		sourceBalance = sourceAccount.getBalance() + balance;
		myBankDao.updateAccount(accountNo, sourceBalance);		
	}
}