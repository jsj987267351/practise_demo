package mybatis_plus.demo4.aaa.service.impl;

import mybatis_plus.demo4.aaa.pojo.User;
import mybatis_plus.demo4.aaa.mapper.UserMapper;
import mybatis_plus.demo4.aaa.service.IUserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
