package springboot_demo.demo7.impl;

import org.springframework.stereotype.Service;
import springboot_demo.demo7.BookService;

@Service
public class BookServiceImpl implements BookService {
    @Override
    public void save() {
        System.out.println("running....");
    }
}
