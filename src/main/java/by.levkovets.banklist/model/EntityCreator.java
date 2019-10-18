package by.levkovets.banklist.model;

import by.levkovets.banklist.model.impl.Account;
import by.levkovets.banklist.model.impl.User;

public class EntityCreator {

    public static User creatNewUser(int id, String name, String sureName) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setSureName(sureName);
        return user;
    }

    public static Account creatNewAccount(int id, int accountValue, int userId) {
        Account account = new Account();
        account.setId(id);
        account.setAccount(accountValue);
        account.setUserId(userId);
        return account;
    }
}
