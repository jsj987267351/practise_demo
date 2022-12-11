package springboot_basis.SSMP.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import springboot_basis.SSMP.pojo.Book;

public interface IBookService extends IService<Book> {

    IPage<Book> getPage(int currentPage , int pageSize);

    IPage<Book> getPage(int currentPage , int pageSize,Book book);

}
