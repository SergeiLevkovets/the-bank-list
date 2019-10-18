package by.levkovets.banklist.service;

import by.levkovets.banklist.model.impl.Account;
import by.levkovets.banklist.model.impl.User;

import java.util.List;

public interface Service {
    User getRichestUser();

    Integer getSumAllAccounts();
}
