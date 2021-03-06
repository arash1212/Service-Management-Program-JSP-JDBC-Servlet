package com.salehi.programming_challenge__1.model.service;

import com.salehi.programming_challenge__1.model.entity.Service;
import com.salehi.programming_challenge__1.model.entity.Service_vaset;
import com.salehi.programming_challenge__1.model.entity.Users;
import com.salehi.programming_challenge__1.model.repository.ServiceRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ServicesService {
    private static final ServicesService instance = new ServicesService();

    private ServicesService() {

    }

    public static ServicesService getInstance() {
        return instance;
    }

    public void save(Service service) throws SQLException {
        try (ServiceRepository serviceRepository = new ServiceRepository()) {
            serviceRepository.save(service);
        }
    }

    public void update(Service service) throws SQLException {
        try (ServiceRepository serviceRepository = new ServiceRepository()) {
            serviceRepository.update(service);
        }
    }

    public Service getOne(Service service) throws SQLException {
        try (ServiceRepository serviceRepository = new ServiceRepository()) {
            return serviceRepository.findOne(service);
        }
    }

    public List<Service> getAll() throws SQLException {
        try (ServiceRepository serviceRepository = new ServiceRepository()) {
            return serviceRepository.findAll();
        }
    }

    public List<Users> getAllServiceUsers(Service service) throws SQLException {
        try (ServiceRepository serviceRepository = new ServiceRepository()) {
            return serviceRepository.findServiceUsers(service);
        }
    }

    public List<Service> getAllActiveServices() throws SQLException {
        try (ServiceRepository serviceRepository = new ServiceRepository()) {
            return serviceRepository.findAllActiveServices();
        }
    }

    public Map<Service, Service_vaset> getAllUserServices(Long userId) throws SQLException {
        try (ServiceRepository serviceRepository = new ServiceRepository()) {
            return serviceRepository.findAllUserServices(userId);
        }
    }

}
