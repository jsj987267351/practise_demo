package day2023_03_17.practise01;

import day2023_03_17.practise01.service.BookService;
import day2023_03_17.practise01.service.impl.BookServiceImpl;

public class APP {
    public static void main(String[] args) {
        BookService bookService = new BookServiceImpl();
        bookService.save();
    }
}
