package yongs.temp.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import yongs.temp.mapper.AccountHistoryMapper;
import yongs.temp.mapper.MyBankMapper;
import yongs.temp.vo.Account;
import yongs.temp.vo.AccountHistory;

@Repository
public class MyBankDao extends JdbcDaoSupport {
    private static final Logger logger = LoggerFactory.getLogger(MyBankDao.class);
    
    @Autowired
    public MyBankDao(DataSource dataSource) {
        this.setDataSource(dataSource);
    }
  
    public Account selectAccount(String name) {
    	String selectAccount = MyBankMapper.BASE_SQL + " WHERE name = ?";
        Object[] params = new Object[] { name };
        MyBankMapper mapper = new MyBankMapper();        
        Account account = this.getJdbcTemplate().queryForObject(selectAccount, params, mapper);   
        
        return account;
    }

    public Account selectAccountByNo(String no) {
    	String selectAccount = MyBankMapper.BASE_SQL + " WHERE no = ?";
        Object[] params = new Object[] { no };
        MyBankMapper mapper = new MyBankMapper();        
        Account account = this.getJdbcTemplate().queryForObject(selectAccount, params, mapper);   
        
        return account;
    }
    
    public void updateAccount(String no, long balance) {
    	String updateAccount = "UPDATE account A SET A.balance = ? WHERE A.no = ?";
        Object[] params = new Object[] { balance, no };       
        this.getJdbcTemplate().update(updateAccount, params);      
    }

    public void createAccount(String no, long balance, String name) { 	
    	String createAccount = "INSERT INTO account (no, balance, name) VALUES (?, ?, ?)";
        Object[] params = new Object[] {no,  balance, name };       
        this.getJdbcTemplate().update(createAccount, params);      
    }
    
    public String getNewNo() {
    	String queryMaxNo = "SELECT MAX(no) no FROM account";  	    	
    	String maxNo = (String)getJdbcTemplate().queryForObject(queryMaxNo, new Object[] { }, String.class);
    	String newNo = null;
    	
    	if(maxNo != null) newNo = String.valueOf(Integer.parseInt(maxNo) + 1);
    	else newNo = "20190001";
    	
    	return newNo;
    }

    public void insertAccountHistory(String no, long tmoney, String target) {   	
    	String insertAccountHistory = "INSERT INTO account_history (no, tmoney, date, target) VALUES (?, ?, ?, ?)";
    	
       	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    	Date date = new Date();
    	
        Object[] params = new Object[] {  no, tmoney, dateFormat.format(date), target };       
        this.getJdbcTemplate().update(insertAccountHistory, params);      
    } 
    
    public List<AccountHistory> retrieveAccountHistory(String no) {
    	String sql = AccountHistoryMapper.BASE_SQL + " WHERE no = ? ORDER BY date DESC";
        Object[] params = new Object[] { no };
        AccountHistoryMapper mapper = new AccountHistoryMapper();        
        List<AccountHistory> accountHistory = this.getJdbcTemplate().query(sql, params, mapper);  
        
        return accountHistory;
    }
}