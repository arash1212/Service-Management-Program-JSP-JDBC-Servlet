package com.salehi.programming_challenge__1.model.repository;

import com.salehi.programming_challenge__1.model.common.JDBCConnection;
import com.salehi.programming_challenge__1.model.entity.User_role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRoleRepository implements AutoCloseable {
    private final Connection connection;
    private PreparedStatement preparedStatement;

    public UserRoleRepository() throws SQLException {
        connection = JDBCConnection.getConnection();
        connection.setAutoCommit(false);
    }

    public void save(User_role user_role) throws SQLException {
        preparedStatement = connection.prepareStatement("select user_role_seq.nextval x from dual");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        user_role.setId(resultSet.getLong("x"));
        preparedStatement = connection.prepareStatement("insert into user_role(id,role_name,address) values (?,?,?)");
        preparedStatement.setLong(1, user_role.getId());
        preparedStatement.setString(2, user_role.getRole_name());
        preparedStatement.setString(3, user_role.getAddress());
        preparedStatement.executeUpdate();
    }

    public void update(User_role user_role) throws SQLException {
        preparedStatement = connection.prepareStatement("update USER_ROLE set ROLE_NAME=? , ADDRESS=? where id=?");
        preparedStatement.setString(1, user_role.getRole_name());
        preparedStatement.setString(2, user_role.getAddress());
        preparedStatement.setLong(3, user_role.getId());
        preparedStatement.executeUpdate();
    }

    public void delete(User_role user_role) throws SQLException {
        preparedStatement = connection.prepareStatement("delete from USER_ROLE where id=?");
        preparedStatement.setLong(1, user_role.getId());
        preparedStatement.executeUpdate();
    }

    public User_role getOneByName(User_role user_role) throws SQLException {
        preparedStatement = connection.prepareStatement("select * from USER_ROLE where ROLE_NAME =?");
        preparedStatement.setString(1, user_role.getRole_name());
        //
        ResultSet resultSet = preparedStatement.executeQuery();
        //
        if(resultSet.next()) {
            return new User_role().setId(resultSet.getLong("id"))
                    .setRole_name(resultSet.getString("role_name"))
                    .setAddress(resultSet.getString("address"));
        }else return null;
    }

    public List<User_role> findAllByName(User_role user_role) throws SQLException {
        preparedStatement = connection.prepareStatement("select * from USER_ROLE where ROLE_NAME =?");
        preparedStatement.setString(1, user_role.getRole_name());
        //
        ResultSet resultSet = preparedStatement.executeQuery();
        //
        List<User_role> userRoles = new ArrayList<>();
        while (resultSet.next()) {
            //
            user_role.setId(resultSet.getLong("id"))
                    .setRole_name(resultSet.getString("role_name"))
                    .setAddress(resultSet.getString("address"));
            //
            userRoles.add(user_role);
        }
        return userRoles;
    }

    public User_role findRoleById(User_role user_role) throws SQLException {
        preparedStatement = connection.prepareStatement("select * from USER_ROLE where ID=?");
        preparedStatement.setLong(1, user_role.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        //
        if (resultSet.next()) {
            return user_role.setId(resultSet.getLong("id"))
                    .setRole_name(resultSet.getString("role_name"))
                    .setAddress(resultSet.getString("address"));
        }else return null;
    }

    public List<User_role> getAll() throws SQLException {
        preparedStatement = connection.prepareStatement("select * from USER_ROLE order by id");
        ResultSet resultSet = preparedStatement.executeQuery();

        List<User_role> userRoles = new ArrayList<>();
        User_role user_role;
        while (resultSet.next()) {
            user_role = new User_role()
                    .setId(resultSet.getLong("id"))
                    .setRole_name(resultSet.getString("role_name"))
                    .setAddress(resultSet.getString("address"));

            userRoles.add(user_role);
        }
        return userRoles;
    }

    @Override
    public void close() throws SQLException {
        connection.commit();
        connection.close();
    }
}
