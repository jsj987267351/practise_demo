package springboot_basis.SSMP.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot_basis.SSMP.pojo.Book;
import springboot_basis.SSMP.service.IBookService;

//lombok提供了记录日志的注解，并且参数就叫log
@Slf4j
@RestController
@RequestMapping("/books")
public class bookController {

//    创建记录日志对象   快速方法用lombok的@Slf4j注解
//    private static  final Logger log = LoggerFactory.getLogger(bookController.class);

    @Autowired
    private IBookService bookService;

    @GetMapping
    public Result getAll() {
//        日志记录
        log.debug("debug..");
        log.info("info..");
        log.error("error..");
        log.warn("warn..");
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
