package yongs.temp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import yongs.temp.dao.EmployeeDao;
import yongs.temp.vo.Employee;

@Controller
public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeDao employeeDao;

	@RequestMapping("/employee/list")
	public String userInfo(HttpServletRequest req, Model model) throws Exception {
		List<Employee> employeeList = employeeDao.getEmployeeList();
		model.addAttribute("employeeList", employeeList);

		return "employee/employeeList";
	}

	@RequestMapping("/employee/searchForm")
	public String searchForm() {
		return "employee/employeeSearch";
	}

	@RequestMapping("/employee/search")
	public String userSearch(HttpServletRequest req, Model model) throws Exception {
		String name = req.getParameter("name");
		logger.info("name ::::: " + name);
		// 시작 시간
        long startTime = System.currentTimeMillis();
		Employee employee = employeeDao.findEmployee(name);
		// 종료 시간
        long endTime = System.currentTimeMillis();
        String elapse =  ( endTime - startTime )/1000.0f +"초";
		model.addAttribute("employee", employee);
		model.addAttribute("elapse", elapse);
		logger.info("employee address ::::: " + employee.getAddress());

		return "employee/employeeInfo";
	}
	
	@ExceptionHandler({EmptyResultDataAccessException.class}) 
	public String userError(HttpServletRequest req, Model model) { 
		// Nothing to do. Returns the logical view name of an error page, passed to 
		// the view-resolver(s) in usual way. 
		// Note that the exception is _not_ available to this view (it is not added to 
		// the model) but see "Extending ExceptionHandlerExceptionResolver" below. 
		String username = (String) req.getParameter("name");
		model.addAttribute("out", username+"는 존재하지 않는 Employee 입니다.");
		return "employee/employeeSearch"; 
	} 
}