package day2023_03_18.practise13.dao.impl;

import day2023_03_18.practise13.dao.BookDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository("bookDao")
public class BookDaoImpl implements BookDao {
    //@Value：注入简单类型（无需提供set方法）
//    @Value("小丑")
    @Value("${name}")
    private String name;

    public void save() {
        System.out.println("book dao save ..." + name);
    }
}
