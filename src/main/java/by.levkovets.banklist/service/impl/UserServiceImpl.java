package by.levkovets.banklist.service.impl;

import by.levkovets.banklist.dao.impl.UserDao;
import by.levkovets.banklist.model.impl.Account;
import by.levkovets.banklist.model.impl.User;
import by.levkovets.banklist.service.Service;

import java.util.List;

public class UserServiceImpl implements Service<User> {
    private static UserDao userDao = new UserDao();
    private static AccountServiceImpl accountService = new AccountServiceImpl();

    @Override
    public void save(User obj) {
        userDao.save(obj);
    }

    @Override
    public void update(User obj) {
        userDao.update(obj);
    }

    @Override
    public void delete(User obj) {
        userDao.delete(obj);
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    public String getRichestUser(List<User> userList) {
        int result = 0;
        User richestUser = null;
        for (User user : userList) {
            List<Account> userAccounts = accountService.findAllByUserId(user);
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

    public String getSumAccounts(List<Account> list) {
        int sumAccount = 0;
        for (Account account : list) {
            sumAccount += account.getAccount();
        }
        return String.valueOf(sumAccount);
    }

}
