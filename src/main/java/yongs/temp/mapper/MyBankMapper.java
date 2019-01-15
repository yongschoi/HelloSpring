package yongs.temp.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import yongs.temp.vo.Account;

public class MyBankMapper implements RowMapper<Account> {
    public static final String BASE_SQL = "SELECT no, balance, name FROM account";
 
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        String no = rs.getString("no");
        long balance = rs.getInt("balance");
        String name  = rs.getString("name");
 
        return new Account(no, balance, name);
    }  
}