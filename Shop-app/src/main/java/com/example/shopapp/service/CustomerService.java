package com.example.shopapp.service;
import com.example.shopapp.model.Customer;
import com.example.shopapp.repository.CustomerDao;
import java.util.List;
public class CustomerService {
    private CustomerDao customerDao = new CustomerDao();
    public CustomerService() {
    }
    public List<Customer> findAll() {
        return customerDao.findAll();
    }
    public Customer findOne(final long id) {
        return customerDao.findOne(id);
    }
    public void save(final Customer entity)
    {
        if (entity == null)
            return;
        customerDao.save(entity);
    }
    public void update(final Customer entity)
    {
        if (entity == null)
            return;
        customerDao.update(entity);
    }
    public void delete(final Customer entity)
    {
        if (entity == null)
            return;
        customerDao.delete(entity);
    }
    public void deleteById(final Long id)
    {
        if (id == null)
            return;
        customerDao.deleteById(id);
    }
}

