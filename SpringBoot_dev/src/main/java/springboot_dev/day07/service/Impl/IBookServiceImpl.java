package springboot_dev.day07.service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import springboot_dev.day07.mapper.BookMapper;
import springboot_dev.day07.pojo.Book;
import springboot_dev.day07.service.IBookService;

import java.util.HashMap;
import java.util.List;

//@Service
public class IBookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

    @Autowired
    private BookMapper bookMapper;

    private HashMap<Integer, Book> cache = new HashMap<Integer, Book>();

//        @Override
//    public Book getById(Integer id) {
////        如果当前缓存中没有本次查询到数据，则进行查询，否则直接从缓存中进行读取
//        Book book = cache.get(id);
//        if (book ==null){
//            Book queryBook = bookMapper.selectById(id);
//            cache.put(id,queryBook);
//            return queryBook;
//        }
//        return book;
//    }
    @Override
//    缓存
//    @Cacheable(value = "cacheSpace" ,key = "#id")
    public Book getById(Integer id) {
        return bookMapper.selectById(id);
    }

    @Override
    public boolean save(Book book) {
        return bookMapper.insert(book) > 0;
    }

    @Override
    public boolean update(Book book) {
        return bookMapper.updateById(book) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return bookMapper.deleteById(id) > 0;
    }

    @Override
    public List<Book> getAll() {
        return bookMapper.selectList(null);
    }
}
