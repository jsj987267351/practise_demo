package springboot_basis.day03.mapper.Impl;

import org.springframework.stereotype.Repository;
import springboot_basis.day03.mapper.BookMapper;

//@Repository
public class BookMapperImpl implements BookMapper {
    @Override
    public void save() {
        System.out.println("Save...");
    }
}
