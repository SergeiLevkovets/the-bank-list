package by.levkovets.banklist.dao.impl;

import by.levkovets.banklist.dao.ConnectionManager;
import by.levkovets.banklist.dao.Dao;
import by.levkovets.banklist.model.EntityCreator;
import by.levkovets.banklist.model.impl.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDao implements Dao<Account> {
    @Override
    public void save(Account obj) {
        Connection connection = null;
        Statement statement = null;

        int id = obj.getId();
        int account = obj.getAccount();
        int userId = obj.getUserId();

        try {
            connection = ConnectionManager.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO bank_list_db.account (account_id, account, fk_user_id) VALUES ('" + id + "', '" + account + "', " + userId + ")");

        } catch (SQLException e) {
            throw new RuntimeException("Some errors occurred during DB access!", e);
        } finally {
            ConnectionManager.closeDbResources(connection, statement);
        }
    }

    @Override
    public void update(Account obj) {
        Connection connection = null;
        Statement statement = null;

        int id = obj.getId();
        int account = obj.getAccount();
        int userId = obj.getUserId();

        try {
            connection = ConnectionManager.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate("UPDATE bank_list_db.account SET account = '" + account + "', fk_user_id = '" + userId + "' WHERE account_id = " + id);

        } catch (SQLException e) {
            throw new RuntimeException("Some errors occurred during DB access!", e);
        } finally {
            ConnectionManager.closeDbResources(connection, statement);
        }
    }

    @Override
    public void delete(Account obj) {
        Connection connection = null;
        Statement statement = null;

        int id = obj.getId();

        try {
            connection = ConnectionManager.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM bank_list_db.account WHERE account_id = " + id);

        } catch (SQLException e) {
            throw new RuntimeException("Some errors occurred during DB access!", e);
        } finally {
            ConnectionManager.closeDbResources(connection, statement);
        }
    }

    @Override
    public Account findById(Integer id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet set = null;
        Account account = null;

        try {
            connection = ConnectionManager.getConnection();
            statement = connection.prepareStatement("select * from bank_list_db.account where account_id=" + id);
            set = statement.executeQuery();

            while (set.next()) {
                int accountId = set.getInt("account_id");
                int accountValue = set.getInt("account");
                int userId = set.getInt("fk_user_id");
                account = EntityCreator.creatNewAccount(accountId, accountValue, userId);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Some errors occurred during DB access!", e);
        } finally {
            ConnectionManager.closeDbResources(connection, statement, set);
        }
        return account;
    }

    @Override
    public List<Account> findAll() {
        List<Account> list = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet set = null;

        try {
            connection = ConnectionManager.getConnection();
            statement = connection.prepareStatement("select * from bank_list_db.account");
            set = statement.executeQuery();

            while (set.next()) {
                int accountId = set.getInt("account_id");
                int accountValue = set.getInt("account");
                int userId = set.getInt("fk_user_id");
                Account account = EntityCreator.creatNewAccount(accountId, accountValue, userId);
                list.add(account);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Some errors occurred during DB access!", e);
        } finally {
            ConnectionManager.closeDbResources(connection, statement, set);
        }
        return list;
    }
}
