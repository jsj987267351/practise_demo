//package springboot_dev.day08.service.Impl;
//
//
//import com.alicp.jetcache.anno.*;
//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.stereotype.Service;
//import springboot_dev.day08.mapper.BookMapper;
//import springboot_dev.day08.pojo.Book;
//import springboot_dev.day08.service.IBookService;
//
//import java.util.HashMap;
//import java.util.List;
//
////@Service
//public class IBookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {
//
//    @Autowired
//    private BookMapper bookMapper;
//
//    @Override
////    开启方法缓存  即SpringBootDevApplication中的注解
//    @Cached(name = "book_",key = "#id",expire = 3600,cacheType = CacheType.REMOTE)
////    不断刷新缓存内容，即不断执行查询，原因为防止两个人可共同修改同一内存，而一人修改另一人为收到通知，即缓存与数据不匹配  refresh为刷新时间  单位为s
////    @CacheRefresh(refresh = 10)
//    public Book getById(Integer id) {
//        return bookMapper.selectById(id);
//    }
//
//    @Override
//    public boolean save(Book book) {
//        return bookMapper.insert(book) > 0;
//    }
//
//    @Override
////    同步更新缓存 表示再次查询更新后的数据时，会直接从缓存中拿出更新后的数据，而不会从内存中拿
//    @CacheUpdate(name = "book_",key = "#book.id",value = "#book")
//    public boolean update(Book book) {
//        return bookMapper.updateById(book) > 0;
//    }
//
//    @Override
////    同步删除缓存
//    @CacheInvalidate(name = "book_",key = "#id")
//    public boolean delete(Integer id) {
//        return bookMapper.deleteById(id) > 0;
//    }
//
//    @Override
//    public List<Book> getAll() {
//        return bookMapper.selectList(null);
//    }
//}
