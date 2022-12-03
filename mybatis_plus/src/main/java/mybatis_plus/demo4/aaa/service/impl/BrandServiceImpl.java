package mybatis_plus.demo4.aaa.service.impl;

import mybatis_plus.demo4.aaa.pojo.Brand;
import mybatis_plus.demo4.aaa.mapper.BrandMapper;
import mybatis_plus.demo4.aaa.service.IBrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 张朝证
 * @since 2022-12-03
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {

}
