package day2023_03_17.practise07.service.impl;

import day2023_03_17.practise07.dao.BookDao;
import day2023_03_17.practise07.service.BookService;

public class BookServiceImpl implements BookService{
    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void save() {
        System.out.println("book service save ...");
        bookDao.save();
    }
}
