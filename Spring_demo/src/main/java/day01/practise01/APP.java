package day01.practise01;

import day01.practise01.service.BookService;
import day01.practise01.service.impl.BookServiceImpl;

public class APP {
    public static void main(String[] args) {
        BookService bookService = new BookServiceImpl();
        bookService.save();
    }
}
