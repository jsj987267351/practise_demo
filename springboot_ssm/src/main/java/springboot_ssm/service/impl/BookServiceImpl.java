package springboot_ssm.service.impl;//package day02.practise11.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot_ssm.controller.Code;
import springboot_ssm.exception.BusinessException;
import springboot_ssm.mapper.BookMapper;
import springboot_ssm.pojo.Book;
import springboot_ssm.service.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public boolean add(Book book) {
        return bookMapper.add(book) > 0;
    }

    @Override
    public boolean update(Book book) {
        return bookMapper.update(book)>0;

    }

    @Override
    public boolean delete(Integer id) {
        return bookMapper.delete(id)>0;

    }

    @Override
    public Book getById(Integer id) {
        if(id ==1){
            throw new BusinessException(Code.BUSINESS_ERR,"请勿使用你的技术挑战我的忍耐性!");
        }
        Book book = bookMapper.getById(id);
        return book;
    }

    @Override
    public List<Book> getAll() {
        List<Book> books = bookMapper.getAll();
        return books;
    }
}
