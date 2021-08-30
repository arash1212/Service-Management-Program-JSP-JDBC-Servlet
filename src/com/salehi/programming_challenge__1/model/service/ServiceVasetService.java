package com.salehi.programming_challenge__1.model.service;

import com.salehi.programming_challenge__1.model.entity.Service;
import com.salehi.programming_challenge__1.model.entity.Users;
import com.salehi.programming_challenge__1.model.repository.ServiceVasetRepository;

import java.sql.SQLException;

public class ServiceVasetService {
    private static final ServiceVasetService instance = new ServiceVasetService();

    private ServiceVasetService() {

    }

    public static ServiceVasetService getInstance() {
        return instance;
    }

    public void save(Users users, Service service) throws SQLException {
        try (ServiceVasetRepository serviceVasetRepository = new ServiceVasetRepository()) {
            serviceVasetRepository.save(users, service);
        }
    }
}
