package com.websystique.spring.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.websystique.spring.model.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao{

	@Autowired
	public EmployeeDaoImpl(SessionFactory sessionfactory){
		setSessionFactory(sessionfactory);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> findAllEmployees() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		criteria.add(Restrictions.eq("first_name", "Georgi"));
		List<Employee> empList = (List<Employee>) getHibernateTemplate().findByCriteria(criteria);
		return empList;
	}
}
