package day2023_03_18.practise09.dao.impl;

import day2023_03_18.practise09.dao.BookDao;

public class BookDaoImpl implements BookDao {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void save() {
        System.out.println("book dao save ..." + name);
    }
}
