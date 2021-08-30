package com.salehi.programming_challenge__1.model.repository;

import com.salehi.programming_challenge__1.model.common.JDBCConnection;
import com.salehi.programming_challenge__1.model.entity.Service;
import com.salehi.programming_challenge__1.model.entity.Service_vaset;
import com.salehi.programming_challenge__1.model.entity.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceVasetRepository implements AutoCloseable {

    private final Connection connection;
    private PreparedStatement preparedStatement;

    public ServiceVasetRepository() throws SQLException {
        connection = JDBCConnection.getConnection();
        connection.setAutoCommit(false);
    }

    public void save(Users users, Service service) throws SQLException {
        preparedStatement = connection.prepareStatement("insert into SERVICE_VASET(user_id, service_id) values (?,?)");
        preparedStatement.setLong(1, users.getId());
        preparedStatement.setLong(2, service.getId());
        preparedStatement.executeUpdate();
    }

    public void removeUserFromService(Users users, Service service) throws SQLException {
        preparedStatement = connection.prepareStatement("delete from SERVICE_VASET where USER_ID=? and SERVICE_ID=?");
        preparedStatement.setLong(1, users.getId());
        preparedStatement.setLong(2, service.getId());
        System.out.println(preparedStatement.executeUpdate() + " users removed from service (vaset)");
        //
    }

    public Service_vaset findOne(Service_vaset serviceVaset) throws SQLException {
        preparedStatement = connection.prepareStatement("select * from SERVICE_VASET where USER_ID=? and SERVICE_ID=?");
        preparedStatement.setLong(1, serviceVaset.getUser_id());
        preparedStatement.setLong(2, serviceVaset.getService_id());
        ResultSet resultSet = preparedStatement.executeQuery();
        //
        if (resultSet.next()) {
            return new Service_vaset().setService_id(resultSet.getLong("USER_ID")).setService_id(resultSet.getLong("SERVICE_ID"));
        } else return null;
    }


    @Override
    public void close() throws SQLException {
        connection.commit();
        connection.close();
    }

}
