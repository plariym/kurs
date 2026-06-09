package com.example.shopapp.service;

import com.example.shopapp.model.Sales;
import com.example.shopapp.repository.SalesDao;

import java.util.List;

public class SalesService {
    private SalesDao salesDAO = new SalesDao();

    public SalesService() {
    }

    public List<Sales> findAll() {
        return salesDAO.findAll();
    }

    public Sales findOne(final long id) {
        return salesDAO.findOne(id);
    }

    public void save(final Sales entity)
    {
        if (entity == null)
            return;
        salesDAO.save(entity);
    }

    public void update(final Sales entity)
    {
        if (entity == null)
            return;
        salesDAO.update(entity);
    }

    public void delete(final Sales entity)
    {
        if (entity == null)
            return;
        salesDAO.delete(entity);
    }

    public void deleteById(final Long id)
    {
        if (id == null)
            return;
        salesDAO.deleteById(id);
    }
}