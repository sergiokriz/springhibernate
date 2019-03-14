package com.websystique.spring;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import com.websystique.spring.configuration.AppConfig;
import com.websystique.spring.model.Employee;
import com.websystique.spring.service.EmployeeService;
import org.springframework.stereotype.Component;

@Component
public class AppMain {

	@Autowired
	EmployeeService employeeService;

	public static void main(String args[]) {

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppMain app = context.getBean(AppMain.class);
		app.start(args);
		context.close();
	}

	private void start(String[] args) {
		List<Employee> employeeList =  employeeService.findAllEmployees();
		System.out.println(employeeList.size());
	}
}
