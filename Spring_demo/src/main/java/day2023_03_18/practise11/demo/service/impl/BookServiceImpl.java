package day2023_03_18.practise11.demo.service.impl;

import day2023_03_18.practise11.demo.dao.BookDao;
import day2023_03_18.practise11.demo.service.BookService;
import org.springframework.stereotype.Service;
//@Component定义bean
//@Component
@Service
public class BookServiceImpl implements BookService {
    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void save() {
        System.out.println("book service save ...");
        bookDao.save();
    }
}
