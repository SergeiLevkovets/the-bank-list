package by.levkovets.banklist.dao.impl;

import by.levkovets.banklist.model.impl.Account;
import by.levkovets.banklist.model.impl.User;
import by.levkovets.banklist.dao.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDao extends AccountJDBCDao {

    @Override
    public List<Account> findAllByUserId(User user) {
        List<Account> list = new ArrayList<>();
        int id = user.getId();

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet set = null;

        try {
            connection = ConnectionManager.getConnection();
            statement = connection.prepareStatement("select * from bank_list_db.account where fk_user_id=" + id + "");
            set = statement.executeQuery();

            while (set.next()) {
                int accountId = set.getInt("account_id");
                int account = set.getInt("account");
                int userId = set.getInt("fk_user_id");
                list.add(new Account(accountId, account, userId));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Some errors occurred during DB access!", e);
        } finally {
            ConnectionManager.closeDbResources(connection, statement, set);
        }
        return list;
    }
}
