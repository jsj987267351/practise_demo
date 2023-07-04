package day2023_03_17.practise02.mapper.impl;

import day2023_03_17.practise02.mapper.BookDao;

public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("book dao save ...");
    }
}
