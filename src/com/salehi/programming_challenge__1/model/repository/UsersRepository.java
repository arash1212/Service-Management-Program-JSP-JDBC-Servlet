package com.salehi.programming_challenge__1.model.repository;

import com.salehi.programming_challenge__1.model.common.JDBCConnection;
import com.salehi.programming_challenge__1.model.entity.User_role;
import com.salehi.programming_challenge__1.model.entity.Users;
import org.apache.catalina.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersRepository implements AutoCloseable {
    private final Connection connection;
    private PreparedStatement preparedStatement;

    public UsersRepository() throws SQLException {
        connection = JDBCConnection.getConnection();
        connection.setAutoCommit(false);
    }

    public void save(Users user) throws SQLException {
        preparedStatement = connection.prepareStatement("select user_seq.nextval x from dual");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        user.setId(resultSet.getLong("x"));
        preparedStatement = connection.prepareStatement("insert into users(id,USERNAME,password,credit,role_id) values (?,?,?,?,?)");
        preparedStatement.setLong(1, user.getId());
        preparedStatement.setString(2, user.getUsername());
        preparedStatement.setString(3, user.getUsername());
        preparedStatement.setLong(4, user.getCredit());
        preparedStatement.setLong(5, user.getRole_id());
        preparedStatement.executeUpdate();
    }

    public Users findUserByUsername(Users users) throws SQLException {
        preparedStatement = connection.prepareStatement("select * from USERS where USERNAME=?");
        preparedStatement.setString(1, users.getUsername());
        ResultSet resultSet = preparedStatement.executeQuery();
        //
        resultSet.next();
        //
        return new Users().setId(resultSet.getLong("id"))
                .setUsername(resultSet.getString("username"))
                .setPassword(resultSet.getString("password"))
                .setCredit(resultSet.getLong("credit"))
                .setRole_id(resultSet.getLong("role_id"));
    }


    @Override
    public void close() throws SQLException {
        connection.commit();
        connection.close();
    }
}
