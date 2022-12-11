package springboot_basis.SSMP.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot_basis.SSMP.pojo.Book;
import springboot_basis.SSMP.service.IBookService;

import java.util.List;

@RestController
@RequestMapping("/books")

public class bookController {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public Result getAll() {
        return new Result(true, bookService.list());
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        return new Result(true, bookService.getById(id));
    }

    @PostMapping
    public Result save(@RequestBody Book book) {
        boolean flag = bookService.save(book);
        return new Result(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }


    @PutMapping
    public Result update(@RequestBody Book book) {
        boolean flag = bookService.updateById(book);
        return new Result(flag, flag ? "更新成功^_^" : "更新失败-_-!");
    }


    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag = bookService.removeById(id);
        return new Result(flag, flag ? "删除成功^_^" : "删除失败-_-!");
    }

    //    @GetMapping("/{currentPage}/{pageSize}")
//    public Result getPage(@PathVariable int currentPage, @PathVariable int pageSize){
//        IPage<Book> page = bookService.getPage(currentPage, pageSize);
//        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
//        if(currentPage > page.getPages()){
//            page = bookService.getPage((int)page.getPages(), pageSize);
//        }
//        return new Result(true,page);
//    }
    @GetMapping("/{currentPage}/{pageSize}")
    public Result getPage(@PathVariable int currentPage, @PathVariable int pageSize, Book book) {
        IPage<Book> page = bookService.getPage(currentPage, pageSize,book);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if (currentPage > page.getPages()) {
            page = bookService.getPage((int) page.getPages(), pageSize,book);
        }
        return new Result(true, page);
    }


}
