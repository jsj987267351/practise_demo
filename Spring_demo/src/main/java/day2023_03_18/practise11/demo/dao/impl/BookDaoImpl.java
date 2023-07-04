package day2023_03_18.practise11.demo.dao.impl;

import day2023_03_18.practise11.demo.dao.BookDao;
import org.springframework.stereotype.Repository;
//@Component定义bean
//@Component("bookDao")
@Repository("bookDao")
//@Controller //表现层
public class BookDaoImpl implements BookDao {
    public void save() {
        System.out.println("book dao save ...");
    }
}
