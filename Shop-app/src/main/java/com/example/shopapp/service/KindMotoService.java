package com.example.shopapp.service;
import com.example.shopapp.model.KindMoto;
import com.example.shopapp.repository.KindMotoDao;

import java.util.List;

public class KindMotoService {
    private KindMotoDao kindMotoDAO = new KindMotoDao();

    public KindMotoService() {
    }

    public List<KindMoto> findAll() {
        return kindMotoDAO.findAll();
    }

    public KindMoto findOne(final long id) {
        return kindMotoDAO.findOne(id);
    }

    public void save(final KindMoto entity)
    {
        if (entity == null)
            return;
        kindMotoDAO.save(entity);
    }

    public void update(final KindMoto entity)
    {
        if (entity == null)
            return;
        kindMotoDAO.update(entity);
    }

    public void delete(final KindMoto entity)
    {
        if (entity == null)
            return;
        kindMotoDAO.delete(entity);
    }

    public void deleteById(final Long id)
    {
        if (id == null)
            return;
        kindMotoDAO.deleteById(id);
    }
}

