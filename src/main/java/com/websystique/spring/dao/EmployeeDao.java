package com.websystique.spring.dao;

import java.util.List;
import com.websystique.spring.model.Employee;

public interface EmployeeDao {

	List<Employee> findAllEmployees();
}
