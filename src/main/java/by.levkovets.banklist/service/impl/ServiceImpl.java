package by.levkovets.banklist.service.impl;

import by.levkovets.banklist.dao.impl.AccountDao;
import by.levkovets.banklist.dao.impl.UserDao;
import by.levkovets.banklist.domain.impl.Account;
import by.levkovets.banklist.domain.impl.User;
import by.levkovets.banklist.service.Service;

import java.util.List;

public class ServiceImpl implements Service {
    private static UserDao userDao = new UserDao();
    private static AccountDao accountDao = new AccountDao();

    public String getRichestUser() {
        int result = 0;
        User richestUser = null;
        List<User> userList = userDao.findAll();
        for (User user : userList) {
            List<Account> userAccounts = accountDao.findAllByUserId(user);
            int sumUserAccount = 0;
            for (Account userAccount : userAccounts) {
                sumUserAccount += userAccount.getAccount();
            }
            if (sumUserAccount > result) {
                result = sumUserAccount;
                richestUser = user;
            }
        }

        return richestUser.toString();
    }

    public String getSumAllAccounts() {
        int sumAccount = 0;
        List<Account> list = accountDao.findAll();
        for (Account account : list) {
            sumAccount += account.getAccount();
        }
        return String.valueOf(sumAccount);
    }
}
