package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import pojo.Book;
import service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping()
    public boolean add(@RequestBody Book book) {
        return bookService.add(book);
    }

    @PutMapping
    public boolean update(@RequestBody Book book) {
        return bookService.update(book);

    }

    @DeleteMapping("/{id}")
    public boolean delete( @PathVariable Integer id) {
        return bookService.delete(id);

    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Integer id) {
        return bookService.getById(id);

    }

    @GetMapping
    public List<Book> getAll() {
        return bookService.getAll();

    }
}
