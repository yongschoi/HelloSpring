package yongs.temp.biz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import yongs.temp.dao.MyBankDao;
import yongs.temp.exception.InsufficientException;
import yongs.temp.mapper.AccountMapper;
import yongs.temp.vo.Account;

@Service("transfer")
public class Transfer {
	private static final Logger logger = LoggerFactory.getLogger(Transfer.class);

	@Autowired
	private MyBankDao myBankDao;

	@Autowired
	private AccountMapper accountMapper;

	@Transactional
	public void commit(String sourceNo, int tmoney, String targetNo) throws Exception {
		// My bank
		Account sourceAccount = myBankDao.selectAccountByNo(sourceNo);
		long sourceBalance = 0;
		if (tmoney > sourceAccount.getBalance())
			throw new InsufficientException();
		
		sourceBalance = sourceAccount.getBalance() - tmoney;
		myBankDao.updateAccount(sourceNo, sourceBalance);
		
		// Your bank
		long targetBalance = 0;
		Account targetAccount = accountMapper.selectAccount(targetNo);
		targetBalance = targetAccount.getBalance() + tmoney;
		targetAccount.setBalance(targetBalance);
		
		accountMapper.updateAccount(targetAccount);
	}
	
	@Transactional
	public void insertHistory(String no, int tmoney, String targetNo) {
		myBankDao.insertAccountHistory(no, tmoney, targetNo);
	}
}