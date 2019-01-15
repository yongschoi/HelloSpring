package yongs.temp.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import yongs.temp.vo.AccountHistory;

public class AccountHistoryMapper implements RowMapper<AccountHistory> {
    public static final String BASE_SQL = "SELECT no, tmoney, date, target FROM account_history";
 
    public AccountHistory mapRow(ResultSet rs, int rowNum) throws SQLException {
        String no = rs.getString("no");
        long tmoney = rs.getInt("tmoney");
        String date  = rs.getString("date");
        String target = rs.getString("target");     
 
        return new AccountHistory(no, tmoney, date, target);
    }  
}