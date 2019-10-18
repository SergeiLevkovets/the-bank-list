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

    public List<User> getAllUser (){
        return userDao.findAll();
    }

    public List<Account> getAllAccount (){
        return accountDao.findAll();
    }

    private List<Account> getUserAccounts(User user) {
        List<Account> resultList = new ArrayList<>();
        int userId = user.getId();
        for (Account account : getAllAccount()) {
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
    public User getRichestUser() {
        int result = 0;
        User richestUser = null;
        for (User user : getAllUser()) {
            List<Account> userAccounts = getUserAccounts(user);
            int sumUserAccount = getSumAccounts(userAccounts);
            if (sumUserAccount > result) {
                result = sumUserAccount;
                richestUser = user;
            }
        }
        return richestUser;
    }

    @Override
    public Integer getSumAllAccounts() {
        Integer sum = getSumAccounts(getAllAccount());
        return sum;
    }

}
