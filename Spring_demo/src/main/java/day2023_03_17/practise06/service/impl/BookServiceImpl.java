package day2023_03_17.practise06.service.impl;

import day2023_03_17.practise06.dao.BookDao;
import day2023_03_17.practise06.dao.UserDao;
import day2023_03_17.practise06.service.BookService;

public class BookServiceImpl implements BookService{
    private BookDao bookDao;
    private UserDao userDao;

    public BookServiceImpl(BookDao bookDao, UserDao userDao) {
        this.bookDao = bookDao;
        this.userDao = userDao;
    }

    public void save() {
        System.out.println("book service save ...");
        bookDao.save();
        userDao.save();
    }
}
