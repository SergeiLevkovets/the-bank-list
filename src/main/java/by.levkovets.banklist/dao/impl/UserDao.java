package by.levkovets.banklist.dao.impl;

import by.levkovets.banklist.dao.Dao;
import by.levkovets.banklist.model.impl.User;
import by.levkovets.banklist.dao.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements Dao<User> {
    @Override
    public void save(User user) {
        Connection connection = null;
        Statement statement = null;

        int id = user.getId();
        String name = user.getName();
        String sureName = user.getSureName();

        try {
            connection = ConnectionManager.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO bank_list_db.user (user_id, name, sure_Name) VALUES ('" + id + "', '" + name + "', " + sureName + ")");

        } catch (SQLException e) {
            throw new RuntimeException("Some errors occurred during DB access!", e);
        } finally {
            ConnectionManager.closeDbResources(connection, statement);
        }
    }

    @Override
    public void update(User user) {
        Connection connection = null;
        Statement statement = null;

        int id = user.getId();
        String name = user.getName();
        String sureName = user.getSureName();

        try {
            connection = ConnectionManager.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate("UPDATE bank_list_db.user SET name = '" + name + "', sure_Name = '" + sureName + "' WHERE user_id = " + id);

        } catch (SQLException e) {
            throw new RuntimeException("Some errors occurred during DB access!", e);
        } finally {
            ConnectionManager.closeDbResources(connection, statement);
        }
    }

    @Override
    public void delete(User user) {
        Connection connection = null;
        Statement statement = null;

        int id = user.getId();

        try {
            connection = ConnectionManager.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM bank_list_db.user WHERE user_id = " + id);

        } catch (SQLException e) {
            throw new RuntimeException("Some errors occurred during DB access!", e);
        } finally {
            ConnectionManager.closeDbResources(connection, statement);
        }
    }

    @Override
    public User findById(Integer id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet set = null;
        User user = null;

        try {
            connection = ConnectionManager.getConnection();
            statement = connection.prepareStatement("select * from bank_list_db.user where user_id=" + id);
            set = statement.executeQuery();

            while (set.next()) {
                Integer usrId = set.getInt("user_id");                // Вот так получать данные - очень плохо!
                String name = set.getString("name");    // А вот так - очень хорошо!
                String sureName = set.getString("sure_Name");
                user = new User(usrId, name, sureName);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Some errors occurred during DB access!", e);
        } finally {
            ConnectionManager.closeDbResources(connection, statement, set);
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet set = null;

        try {
            connection = ConnectionManager.getConnection();
            statement = connection.prepareStatement("select * from bank_list_db.user");
            set = statement.executeQuery();

            while (set.next()) {
                Integer id = set.getInt("user_id");                // Вот так получать данные - очень плохо!
                String name = set.getString("name");    // А вот так - очень хорошо!
                String sureName = set.getString("sure_Name");
                list.add(new User(id, name, sureName));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Some errors occurred during DB access!", e);
        } finally {
            ConnectionManager.closeDbResources(connection, statement, set);
        }
        return list;
    }
}
