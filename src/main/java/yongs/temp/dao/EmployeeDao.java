package yongs.temp.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import yongs.temp.mapper.EmployeeMapper;
import yongs.temp.vo.Employee;

@Repository
public class EmployeeDao extends JdbcDaoSupport {

    @Autowired
    public EmployeeDao(DataSource dataSource) {
        this.setDataSource(dataSource);
    }
    
    @Cacheable(value="sampleCache", key="#name")
    public Employee findEmployee(String name) {
        String sql = EmployeeMapper.BASE_SQL + " WHERE name = ?";
 
        Object[] params = new Object[] { name };
         
        EmployeeMapper mapper = new EmployeeMapper();        
        Employee employee = this.getJdbcTemplate().queryForObject(sql, params, mapper);
              
        return employee;
    }
    
    // @Cacheable(value="sampleCache")
    public List<Employee> getEmployeeList() {
        String sql = EmployeeMapper.BASE_SQL;
 
        Object[] params = new Object[] {};
        EmployeeMapper mapper = new EmployeeMapper();
        List<Employee> employeeList = this.getJdbcTemplate().query(sql, params, mapper);
                           
        return employeeList;
    }
}