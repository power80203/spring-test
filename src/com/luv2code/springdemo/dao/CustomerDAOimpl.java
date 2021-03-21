package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOimpl implements CustomerDAO {
	
	
	
	// need to inject session factory
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		// get session from hiberante config
		Session _s = sessionFactory.getCurrentSession();
		// create a query
		Query<Customer> theQuery = 
				_s.createQuery("from Customer", Customer.class);
		
		// execute and get result set
		List<Customer> customers = theQuery.getResultList();
		

		// return the result
		return customers;
	}

}
