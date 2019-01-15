package yongs.temp.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import yongs.temp.vo.Employee;

public class EmployeeMapper implements RowMapper<Employee> {
    public static final String BASE_SQL = 
    		"SELECT seq, name, birthdate, sex, telephone, address, postal, joblevel_code, department_code, skill_code FROM employee";
 
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
    	String seq = rs.getString("seq");
    	String name = rs.getString("name");
    	String birthdate = rs.getString("birthdate");
    	String sex = rs.getString("sex");
    	String telephone = rs.getString("telephone");
    	String address = rs.getString("address");
    	String postal = rs.getString("postal");
    	String joblevelCode = rs.getString("joblevel_code");
    	String departmentCode = rs.getString("department_code");
    	String skillCode = rs.getString("skill_code");
 
        return new Employee(seq, 
        					name, 
        					birthdate,
        					sex,
        					telephone,
        					address,
        					postal,
        					joblevelCode,
        					departmentCode,
        					skillCode);
    }  
}
