package com.luv2code.springdemo.service;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    // need to inject customer dao, because service depends on dao ( dependency injection )

    @Autowired
    private CustomerDAO customerDAO;

    // now our service will delegate the beginning and the end of the transaction
    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer theCustomer) {

        customerDAO.saveCustomer(theCustomer);

    }

    @Override
    @Transactional
    public Customer getCustomer(int theId) {
        return customerDAO.getCustomer(theId);
    }
}
