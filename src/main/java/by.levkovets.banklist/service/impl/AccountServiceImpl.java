package by.levkovets.banklist.service.impl;

import by.levkovets.banklist.dao.impl.AccountDao;
import by.levkovets.banklist.model.impl.Account;
import by.levkovets.banklist.model.impl.User;
import by.levkovets.banklist.service.Service;

import java.util.List;

public class AccountServiceImpl implements Service<Account> {

    AccountDao accountDao = new AccountDao();

    @Override
    public void save(Account obj) {
        accountDao.save(obj);
    }

    @Override
    public void update(Account obj) {
        accountDao.update(obj);
    }

    @Override
    public void delete(Account obj) {
        accountDao.delete(obj);
    }

    @Override
    public Account findById(Integer id) {
        return accountDao.findById(id);
    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }


    public List<Account> findAllByUserId(User user){
        return accountDao.findAllByUserId(user);
    }

}
