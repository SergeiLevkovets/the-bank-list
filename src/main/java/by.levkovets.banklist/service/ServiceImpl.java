package by.levkovets.banklist.service;

import by.levkovets.banklist.dao.impl.AccountDao;
import by.levkovets.banklist.dao.impl.UserDao;
import by.levkovets.banklist.model.impl.Account;
import by.levkovets.banklist.model.impl.User;

import java.util.ArrayList;
import java.util.List;

public class ServiceImpl implements Service {
    private AccountDao accountDao = new AccountDao();
    private UserDao userDao = new UserDao();

    private List<User> getAllUsers() {
        return userDao.findAll();
    }

    private List<Account> getAllAccounts() {
        return accountDao.findAll();
    }


    private List<Account> getUserAccounts(User user) {
        List<Account> resultList = new ArrayList<>();
        int userId = user.getId();
        for (Account account : getAllAccounts()) {
            if (account.getUserId() == userId) {
                resultList.add(account);
            }
        }
        return resultList;
    }

    private Integer getSumAccounts(List<Account> list) {
        int sumAccount = 0;
        for (Account account : list) {
            sumAccount += account.getAccount();
        }
        return sumAccount;
    }

    @Override
    public String getRichestUser() {
        int result = 0;
        User richestUser = null;
        for (User user : getAllUsers()) {
            List<Account> userAccounts = getUserAccounts(user);
            int sumUserAccount = getSumAccounts(userAccounts);
            if (sumUserAccount > result) {
                result = sumUserAccount;
                richestUser = user;
            }
        }
        return richestUser.toString();
    }

    @Override
    public String getSumAllAccounts() {
        int sum = getSumAccounts(getAllAccounts());
        return String.valueOf(sum);
    }

}
