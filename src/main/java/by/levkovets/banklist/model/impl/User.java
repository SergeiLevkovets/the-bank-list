package by.levkovets.banklist.model.impl;

import by.levkovets.banklist.model.Entity;

import java.util.Objects;

public class User implements Entity {
    private int id;
    private String name;
    private String sureName;

    public User() {}

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    @Override
    public String toString() {
        return "id=" + id + ", " + sureName + " " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                name.equals(user.name) &&
                sureName.equals(user.sureName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sureName);
    }
}
