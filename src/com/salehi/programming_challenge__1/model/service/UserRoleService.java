package com.salehi.programming_challenge__1.model.service;

import com.salehi.programming_challenge__1.model.entity.User_role;
import com.salehi.programming_challenge__1.model.repository.UserRoleRepository;

import java.sql.SQLException;
import java.util.List;

public class UserRoleService {

    private static UserRoleService instance = new UserRoleService();

    private UserRoleService() {

    }

    public static UserRoleService getInstance() {
        return instance;
    }

    public void save(User_role user_role) throws SQLException {
        try (UserRoleRepository user_role_repository = new UserRoleRepository()) {
            user_role_repository.save(user_role);
        }
    }

    public void update(User_role user_role) throws SQLException {
        try (UserRoleRepository userRoleRepository = new UserRoleRepository()) {
            userRoleRepository.update(user_role);
        }
    }

    public void delete(User_role user_role) throws SQLException {
        try (UserRoleRepository userRoleRepository = new UserRoleRepository()) {
            userRoleRepository.delete(user_role);
        }
    }

    public User_role getOneByName(User_role user_role) throws SQLException {
        try (UserRoleRepository userRoleRepository = new UserRoleRepository()) {
            return userRoleRepository.getOneByName(user_role);
        }
    }

    public List<User_role> getAllByName(String roleName) throws SQLException {
        try (UserRoleRepository userRoleRepository = new UserRoleRepository()) {
            return userRoleRepository.findAllByName(roleName);
        }
    }

    public User_role getOneById(Long id) throws SQLException {
        try (UserRoleRepository userRoleRepository = new UserRoleRepository()) {
            return userRoleRepository.findRoleById(id);
        }
    }

    public List<User_role> findAll() throws SQLException {
        try (UserRoleRepository user_role_repository = new UserRoleRepository()) {
            return user_role_repository.getAll();
        }
    }

}
