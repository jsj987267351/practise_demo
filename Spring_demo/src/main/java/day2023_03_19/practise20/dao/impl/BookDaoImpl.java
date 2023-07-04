package day2023_03_19.practise20.dao.impl;

import day2023_03_19.practise20.dao.BookDao;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

    public void update(){
        System.out.println("book dao update is running ...");
    }

    public int select() {
        System.out.println("book dao select is running ...");
//        int i = 1/0;
        return 100;
    }
}
