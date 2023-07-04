package day2023_03_18.practise10.dao.impl;

import day2023_03_18.practise10.dao.BookDao;

public class BookDaoImpl implements BookDao {
    public BookDaoImpl() {
        System.out.println("constructor");
    }

    public void save() {
        System.out.println("book dao save ..." );
    }
}
