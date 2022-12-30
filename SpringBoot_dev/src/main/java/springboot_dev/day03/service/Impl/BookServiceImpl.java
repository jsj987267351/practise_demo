package springboot_dev.day03.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot_dev.day03.mapper.BookMapper;
import springboot_dev.day03.pojo.Book;
import springboot_dev.day03.service.BookService;

//@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public boolean save(Book book) {
        return bookMapper.insert(book) > 0;
    }
}
