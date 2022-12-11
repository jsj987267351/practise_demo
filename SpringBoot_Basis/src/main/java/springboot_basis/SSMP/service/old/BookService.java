package springboot_basis.SSMP.service.old;


import com.baomidou.mybatisplus.core.metadata.IPage;
import springboot_basis.SSMP.pojo.Book;
import java.util.List;

public interface BookService {

    boolean save(Book book);

    boolean update(Book book);

    boolean delete(Integer id);

    Book selectById(Integer id);

    List<Book> selectAll();

    IPage<Book> getPage(int currentPage, int pageSize);

}
