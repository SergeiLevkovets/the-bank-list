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

    ServiceImpl service = new ServiceImpl();
    ServiceImpl serviceSpy = Mockito.spy(service);


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
        Mockito.doReturn(userList).when(serviceSpy).getAllUser();
        Mockito.doReturn(accountList).when(serviceSpy).getAllAccount();
    }

    @Test

    public void getSumAllAccounts() {
        Integer actualSum = 50 + 100 + 150 + 200 + 250;
        Integer expected = serviceSpy.getSumAllAccounts();

        Assert.assertEquals(expected, actualSum);
    }

    @Test
    public void getRichestUser() {

        Assert.assertEquals(serviceSpy.getRichestUser(), richUser);

    }

}