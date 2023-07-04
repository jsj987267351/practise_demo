package day2023_03_19.practise23.demo.dao.impl;

import day2023_03_19.practise23.demo.dao.ResourcesDao;
import org.springframework.stereotype.Repository;

@Repository
public class ResourcesDaoImpl implements ResourcesDao {
    public boolean readResources(String url, String password) {
        System.out.println(password.length());
        //模拟校验
        return password.equals("root");
    }
}
