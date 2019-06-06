package com.t1708m1.model;

import com.t1708m1.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserModel {
    public boolean addUser(User user) {
        try {
            String sqlCommand1 = "insert into user (username, password, phone, email, address) values (?,?,?,?,?)";
            PreparedStatement preparedStatement = ConnectionHel.getConnection().prepareStatement(sqlCommand1);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getPhone());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getAddress());
            preparedStatement.execute();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public ArrayList<User> getList() {
        ArrayList<User> results = new ArrayList<>();
        try {
            String sqlCommand = "select * from user";
            PreparedStatement preparedStatement = ConnectionHel.getConnection().prepareStatement(sqlCommand);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                user.setPhone(phone);
                user.setEmail(email);
                user.setAddress(address);
                results.add(user);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return results;
    }

    public User findByUsernameAndStatus(String username, User.Status status) {
        try {
            String sqlCommand = "select * from user where username = ?  and status = ? ";
            PreparedStatement preparedStatement = ConnectionHel.getConnection().prepareStatement(sqlCommand);
            preparedStatement.setString(1, username);
            preparedStatement.setInt(2, status.getValue());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String rsUsername = resultSet.getString(1);
                String rsPassword = resultSet.getString(2);
                String rsPhone = resultSet.getString(3);
                String rsEmail = resultSet.getString(4);
                String rsAddress = resultSet.getString(5);
                int rsStatus = resultSet.getInt(6);
                User user = new User();
                user.setUsername(rsUsername);
                user.setPassword(rsPassword);
                user.setPhone(rsPhone);
                user.setEmail(rsEmail);
                user.setAddress(rsAddress);

                user.setStatus(User.Status.findByValue(rsStatus));
                return user;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


}
