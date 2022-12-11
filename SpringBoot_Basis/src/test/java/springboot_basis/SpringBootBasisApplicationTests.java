package springboot_basis;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springboot_basis.SSMP.mapper.BookMapper;
import springboot_basis.SSMP.pojo.Book;
import springboot_basis.SSMP.service.IBookService;
import springboot_basis.SSMP.service.old.BookService;


@SpringBootTest
class SpringBootBasisApplicationTests {

    @Autowired
    private BookMapper bookMapper;

//    @Autowired
//    private BookService bookService;

    @Autowired
    private IBookService iBookService;

//    @Autowired
//    private BookMapper bookMapper;

//    @Autowired
//    private BookMapper bookMapper;

//    @Test
//    void test(){
//        bookMapper.save();
//    }

//    day04
//    @Test
//    void test02(){
//        System.out.println(bookMapper.getById(2));
//    }

////    day05
//    @Test
//    void test03(){
//        System.out.println(bookMapper.selectById(2));
//    }

    //    day06
//    @Test
//    void test04(){
//        System.out.println(bookMapper.selectById(2));
//    }

//    SSMP
//    @Test
//    public void testgetById(){
//        System.out.println(bookMapper.selectById(2));
//    }
//
//    @Test
//    public void testSave(){
//        Book book = new Book();
//        book.setType("测试");
//        book.setName("测试");
//        book.setDescription("测试");
//        bookMapper.insert(book);
//    }
//
//    @Test
//    public void testUpdateById(){
//        Book book = new Book();
//        book.setId(15);
//        book.setType("测试2");
//        book.setName("测试2");
//        book.setDescription("测试2");
//        bookMapper.updateById(book);
//    }
//
//    @Test
//    public void testdeleteById(){
//        bookMapper.deleteById(15);
//    }
//
//    @Test
//    public void getAll(){
//        bookMapper.selectList(null);
//    }
//
//    @Test
//    void testGetPage(){
//
//        IPage iPage = new Page(2,5);   //第一页，显示五条
//        bookMapper.selectPage(iPage,null);  //返回值为83行创建的ipage，所以可以用过ipage拿数据
//        System.out.println(iPage.getRecords());
//        System.out.println(iPage.getSize());
//        System.out.println(iPage.getPages());
//        System.out.println(iPage.getTotal());
//        System.out.println(iPage.getCurrent());
//
//    }
//
////    按条件查询
//    @Test
//    void testGetBy(){
//        QueryWrapper<Book> queryWrapper = new QueryWrapper<Book>();
//        queryWrapper.like("name","Spring");   //用name属性去模糊匹配Spring
//        bookMapper.selectList(queryWrapper);
//    }
//
//    @Test
//    void testGetBy2(){
//        String name = null;
//        LambdaQueryWrapper<Book> lq = new LambdaQueryWrapper<Book>();
//        lq.like(name!=null,Book::getName,name);
//        bookMapper.selectList(lq);
//    }

//    SSMP service 测试
//    @Test
//    void getById(){
//        System.out.println(bookService.selectById(2));
//    }
//
//    @Test
//    public void testSave(){
//        Book book = new Book();
//        book.setType("测试");
//        book.setName("测试");
//        book.setDescription("测试");
//        bookService.save(book);
//    }
//    @Test
//    public void testUpdateById(){
//        Book book = new Book();
//        book.setId(16);
//        book.setType("测试2");
//        book.setName("测试2");
//        book.setDescription("测试2");
//        bookService.update(book);
//    }
//
//    @Test
//    public void testdeleteById(){
//        bookService.delete(16);
//    }
//
//    @Test
//    public void getAll(){
//        System.out.println(bookService.selectAll());
//    }
//
//    @Test
//    void testGetPage(){
//        IPage<Book> iPage = bookService.getPage(2, 5);
//        System.out.println(iPage.getRecords());
//        System.out.println(iPage.getSize());
//        System.out.println(iPage.getPages());
//        System.out.println(iPage.getTotal());
//        System.out.println(iPage.getCurrent());
//
//    }
//
//    //    按条件查询
//    @Test
//    void testGetBy(){
//        QueryWrapper<Book> queryWrapper = new QueryWrapper<Book>();
//        queryWrapper.like("name","Spring");   //用name属性去模糊匹配Spring
//        bookMapper.selectList(queryWrapper);
//    }
//
//    @Test
//    void testGetBy2(){
//        String name = null;
//        LambdaQueryWrapper<Book> lq = new LambdaQueryWrapper<Book>();
//        lq.like(name!=null,Book::getName,name);
//        bookMapper.selectList(lq);
//    }

//    运用Iservice测试
@Test
void getById(){
    System.out.println(iBookService.getById(2));
}

    @Test
    public void testSave(){
        Book book = new Book();
        book.setType("测试");
        book.setName("测试");
        book.setDescription("测试");
        iBookService.save(book);
    }
    @Test
    public void testUpdateById(){
        Book book = new Book();
        book.setId(17);
        book.setType("测试2");
        book.setName("测试2");
        book.setDescription("测试2");
        iBookService.updateById(book);
    }

    @Test
    public void testdeleteById(){
        iBookService.removeById(17);
    }

    @Test
    public void getAll(){
        System.out.println(iBookService.list());
    }

    @Test
    void testGetPage(){
        IPage<Book> iPage = new Page<Book>(2,5);
        iBookService.page(iPage);
        System.out.println(iPage.getRecords());
        System.out.println(iPage.getSize());
        System.out.println(iPage.getPages());
        System.out.println(iPage.getTotal());
        System.out.println(iPage.getCurrent());

    }

}
