package com.stackroute.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.model.Customer;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Customer customer) {
		
		 sessionFactory.getCurrentSession().save(customer);
	}

	@Override
	public List<Customer> customerList() {
		String hql = "from Customer";
		@SuppressWarnings("unchecked")
		List<Customer> clist= sessionFactory.getCurrentSession()
									.createQuery(hql).getResultList();
		return clist;
	}

}
