package day03.practise22.demo.dao.impl;

import day03.practise22.demo.dao.BookDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

    public String findName(int id,String password) {
        System.out.println("id:"+id);
//        if(true)throw new NullPointerException();
        return "Joker";
    }
}
