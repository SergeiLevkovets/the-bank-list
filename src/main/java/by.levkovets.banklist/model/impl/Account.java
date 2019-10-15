package by.levkovets.banklist.model.impl;

import by.levkovets.banklist.model.Entity;

import java.util.Objects;

public class Account implements Entity {
    private int id;
    private int account;
    private int userId;

    public Account(int id, int account, int userId) {
        this.id = id;
        this.account = account;
        this.userId = userId;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", account=" + account +
                ", userId=" + userId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account1 = (Account) o;
        return id == account1.id &&
                account == account1.account &&
                userId == account1.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, account, userId);
    }
}
