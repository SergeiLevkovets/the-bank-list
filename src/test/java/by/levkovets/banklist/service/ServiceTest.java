package by.levkovets.banklist.service;

import by.levkovets.banklist.model.EntityCreator;
import by.levkovets.banklist.model.impl.Account;
import by.levkovets.banklist.model.impl.User;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class ServiceTest {

    ServiceImpl serviceTest = Mockito.mock(ServiceImpl.class);

    List<User> userList = new ArrayList<>();
    List<Account> accountList = new ArrayList<>();
    User richUser = EntityCreator.creatNewUser(2, "Sidor", "Sidorov");

    {
        userList.add(richUser);
        userList.add(EntityCreator.creatNewUser(1, "Ivan", "Ivanov"));
        userList.add(EntityCreator.creatNewUser(3, "Petr", "Petrov"));
        accountList.add(EntityCreator.creatNewAccount(1, 50, 1));
        accountList.add(EntityCreator.creatNewAccount(2, 100, 2));
        accountList.add(EntityCreator.creatNewAccount(3, 150, 3));
        accountList.add(EntityCreator.creatNewAccount(4, 200, 1));
        accountList.add(EntityCreator.creatNewAccount(5, 250, 2));
        Mockito.when(serviceTest.getAllUser()).thenReturn(userList);
        Mockito.when(serviceTest.getAllAccount()).thenReturn(accountList);
    }


    @Test
    public void getRichestUser() {

        Assert.assertEquals(serviceTest.getRichestUser(), serviceTest.getAllUser());

    }

    @Test
    public void getSumAllAccounts() {
        Integer actualSum = 0;
        for (Account account : accountList) {
            actualSum += account.getAccount();
        }

        Assert.assertEquals(serviceTest.getSumAllAccounts(), actualSum);
    }
}