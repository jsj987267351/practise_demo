//package day02.practise10.service.impl;
//
//import day02.practise10.controller.Code;
//import day02.practise10.exception.BusinessException;
//import day02.practise10.exception.SystemException;
//import day02.practise10.mapper.BookMapper;
//import day02.practise10.pojo.Book;
//import day02.practise10.service.BookService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class BookServiceImpl implements BookService {
//
//    @Autowired
//    private BookMapper bookMapper;
//
//    @Override
//    public boolean add(Book book) {
//        bookMapper.add(book);
//        return true;
//    }
//
//    @Override
//    public boolean update(Book book) {
//        bookMapper.update(book);
//        return true;
//    }
//
//    @Override
//    public boolean delete(Integer id) {
//        bookMapper.delete(id);
//        return true;
//    }
//
//    @Override
//    public Book getById(Integer id) {
//        if(id ==1){
//            throw new BusinessException(Code.BUSINESS_ERR,"请勿使用你的技术挑战我的忍耐性!");
//        }
//        //将可能出线的异常进行包装，转换成自定义异常
//        try {
//            int i = 1/0;
//        }catch (Exception e){
//                throw new SystemException(Code.SYSTEM_TIMEOUT_ERR,"服务器访问超时，请重试！",e);
//        }
//
//        Book book = bookMapper.getById(id);
//        return book;
//    }
//
//    @Override
//    public List<Book> getAll() {
//        List<Book> books = bookMapper.getAll();
//        return books;
//    }
//}
