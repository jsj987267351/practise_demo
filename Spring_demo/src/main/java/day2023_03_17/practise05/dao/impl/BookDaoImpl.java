package day2023_03_17.practise05.dao.impl;

import day2023_03_17.practise05.dao.BookDao;

public class BookDaoImpl implements BookDao {

    private String databaseName;
    private int connectionNum;

//    //setter注入需要提供要注入对象的set方法
    public void setConnectionNum(int connectionNum) {
        this.connectionNum = connectionNum;
    }
//    //setter注入需要提供要注入对象的set方法
    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public void save() {
        System.out.println("book dao save ..."+databaseName+","+connectionNum);
    }

}
