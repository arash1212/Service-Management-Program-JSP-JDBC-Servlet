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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceRepository implements AutoCloseable {
    private final Connection connection;
    private PreparedStatement preparedStatement;

    public ServiceRepository() throws SQLException {
        connection = JDBCConnection.getConnection();
        connection.setAutoCommit(false);
    }

    public void save(Service service) throws SQLException {
        preparedStatement = connection.prepareStatement("select service_seq.nextval x from dual");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        service.setId(resultSet.getLong("x"));
        preparedStatement = connection.prepareStatement("insert into SERVICE(ID,NAME,PRICE,PEAK,STARTDATE,ENDDATE,STARTTIME,ENDTIME,ACTIVE) values (?,?,?,?,?,?,?,?,?)");
        preparedStatement.setLong(1, service.getId());
        preparedStatement.setString(2, service.getName());
        preparedStatement.setLong(3, service.getPrice());
        preparedStatement.setInt(4, service.getPeak());
        preparedStatement.setString(5, service.getStartDate());
        preparedStatement.setString(6, service.getEndDate());
        preparedStatement.setString(7, service.getStartTime());
        preparedStatement.setString(8, service.getEndTime());
        preparedStatement.setShort(9, service.getActive());
        preparedStatement.executeUpdate();
    }

    public void update(Service service) throws SQLException {
        preparedStatement = connection.prepareStatement("update SERVICE set NAME=?,PRICE=?,PEAK=?,STARTDATE=?,ENDDATE=?,STARTTIME=?,ENDTIME=?,ACTIVE=? where ID=?");
        preparedStatement.setString(1, service.getName());
        preparedStatement.setLong(2, service.getPrice());
        preparedStatement.setInt(3, service.getPeak());
        preparedStatement.setString(4, service.getStartDate());
        preparedStatement.setString(5, service.getEndDate());
        preparedStatement.setString(6, service.getStartTime());
        preparedStatement.setString(7, service.getEndTime());
        preparedStatement.setShort(8, service.getActive());
        preparedStatement.setLong(9, service.getId());
        preparedStatement.executeUpdate();
    }

    public Service findOne(Service service) throws SQLException {
        preparedStatement = connection.prepareStatement("select * from SERVICE where id=?");
        preparedStatement.setLong(1, service.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        //
        if (resultSet.next()) {
            return new Service().setId(resultSet.getLong("id"))
                    .setPeak(resultSet.getInt("peak"))
                    .setPrice(resultSet.getLong("price"))
                    .setName(resultSet.getString("name"))
                    .setActive(resultSet.getShort("active"))
                    .setStartDate(resultSet.getString("startDate"))
                    .setEndDate(resultSet.getString("endDate"))
                    .setEndTime(resultSet.getString("endTime"))
                    .setStartTime(resultSet.getString("startTime"));
        } else return null;
    }


    public List<Service> findAll() throws SQLException {
        preparedStatement = connection.prepareStatement("select * from SERVICE");
        ResultSet resultSet = preparedStatement.executeQuery();
        //
        List<Service> services = new ArrayList<>();
        Service service;
        while (resultSet.next()) {
            service = new Service().setId(resultSet.getLong("id"))
                    .setName(resultSet.getString("name"))
                    .setPrice(resultSet.getLong("price"))
                    .setPeak(resultSet.getInt("peak"))
                    .setStartDate(resultSet.getString("startDate"))
                    .setEndDate(resultSet.getString("endDate"))
                    .setActive(resultSet.getShort("active"))
                    .setEndTime(resultSet.getString("endTime"))
                    .setStartTime(resultSet.getString("startTime"));

            services.add(service);
        }

        return services;
    }

    public List<Users> findServiceUsers(Service service) throws SQLException {
        preparedStatement = connection.prepareStatement("select * from SERVICE_VASET vaset inner join USERS users on vaset.USER_ID = users.ID and vaset.SERVICE_ID=?");
        preparedStatement.setLong(1, service.getId());
        //
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Users> usersList = new ArrayList<>();
        Users users;
        while (resultSet.next()) {
            users = new Users().setId(resultSet.getLong("id"))
                    .setUsername(resultSet.getString("username"))
                    .setCredit(resultSet.getLong("credit"))
                    .setRole_id(resultSet.getLong("role_id"));

            usersList.add(users);
        }
        return usersList;
    }

    public List<Service> findAllActiveServices() throws SQLException {
        preparedStatement = connection.prepareStatement("select * from SERVICE where ACTIVE=1");
        ResultSet resultSet = preparedStatement.executeQuery();
        //
        List<Service> services = new ArrayList<>();
        Service service;
        while (resultSet.next()) {
            service = new Service().setId(resultSet.getLong("id"))
                    .setName(resultSet.getString("name"))
                    .setPrice(resultSet.getLong("price"))
                    .setPeak(resultSet.getInt("peak"))
                    .setStartDate(resultSet.getString("startDate"))
                    .setEndDate(resultSet.getString("endDate"))
                    .setActive(resultSet.getShort("active"))
                    .setEndTime(resultSet.getString("endTime"))
                    .setStartTime(resultSet.getString("startTime"));

            services.add(service);
        }

        return services;
    }

    public Map<Service, Service_vaset> findAllUserServices(Long userId) throws SQLException {
        preparedStatement = connection.prepareStatement("select * from SERVICE service inner join SERVICE_VASET vaset on service.ID = vaset.SERVICE_ID and vaset.USER_ID=?");
        preparedStatement.setLong(1, userId);
        ResultSet resultSet = preparedStatement.executeQuery();
        //
        Map<Service, Service_vaset> services = new HashMap<>();
        Service service;
        Service_vaset serviceVaset;
        while (resultSet.next()) {
            service = new Service().setId(resultSet.getLong("id"))
                    .setName(resultSet.getString("name"))
                    .setPrice(resultSet.getLong("price"))
                    .setPeak(resultSet.getInt("peak"))
                    .setStartDate(resultSet.getString("startDate"))
                    .setEndDate(resultSet.getString("endDate"))
                    .setActive(resultSet.getShort("active"))
                    .setEndTime(resultSet.getString("endTime"))
                    .setStartTime(resultSet.getString("startTime"));
            //
            serviceVaset = new Service_vaset().setService_id(resultSet.getLong("service_id"))
                    .setUser_id(resultSet.getLong("user_id"))
                    .setUseTime(resultSet.getLong("useTime"));
            //


            services.put(service, serviceVaset);
        }

        return services;
    }


    @Override
    public void close() throws SQLException {
        connection.commit();
        connection.close();
    }
}
