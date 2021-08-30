package com.salehi.programming_challenge__1.model.service;

import com.salehi.programming_challenge__1.model.entity.Users;
import com.salehi.programming_challenge__1.model.repository.UsersRepository;

import java.sql.SQLException;

public class UsersService {

    private static UsersService instance = new UsersService();

    private UsersService() {

    }

    public static UsersService getInstance() {
        return instance;
    }

    public void save(Users users) throws SQLException {
        try (UsersRepository usersRepository = new UsersRepository()) {
            usersRepository.save(users);
        }
    }

    public Users findUserByUsername(Users users) throws SQLException {
        try (UsersRepository usersRepository = new UsersRepository()) {
            return usersRepository.findUserByUsername(users);
        }
    }
}
