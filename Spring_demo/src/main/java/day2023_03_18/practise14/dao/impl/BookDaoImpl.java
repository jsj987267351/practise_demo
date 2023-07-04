package day2023_03_18.practise14.dao.impl;

import day2023_03_18.practise14.dao.BookDao;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

    public void save() {
        System.out.println("book dao save ...");
    }
}
