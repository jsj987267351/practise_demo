package day2023_03_17.practise03.dao.impl;

import day2023_03_17.practise03.dao.BookDao;

public class BookDaoImpl implements BookDao {
    public BookDaoImpl() {
        System.out.println("book dao constructor is running...");
    }

    @Override
    public void save() {
        System.out.println("book dao save ...");
    }
}
