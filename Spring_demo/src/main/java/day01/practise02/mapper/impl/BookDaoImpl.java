package day01.practise02.mapper.impl;

import day01.practise02.mapper.BookDao;

public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("book dao save ...");
    }
}
