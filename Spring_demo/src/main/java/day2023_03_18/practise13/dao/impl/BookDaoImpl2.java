package day2023_03_18.practise13.dao.impl;

import day2023_03_18.practise13.dao.BookDao;
import org.springframework.stereotype.Repository;

@Repository("bookDao2")
public class BookDaoImpl2 implements BookDao {
    public void save() {
        System.out.println("book dao save ...2");
    }
}
