package mybatis_plus;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import mybatis_plus.demo3.mapper.UserMapper;
import mybatis_plus.demo3.pojo.User;
import mybatis_plus.demo3.pojo.query.UserQuery;
import net.bytebuddy.matcher.FilterableList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

//    demo1
//    @Test
//    void testSave(){
//        User user = new User();
//        user.setAge(20);
//        user.setName("张朝证");
//        user.setTel("15722401050");
//        user.setPassword("050212");
//        userMapper.insert(user);
//    }
//
//    @Test
//    void testDeleteById(){
//        userMapper.deleteById(1598913639014748161L);
//    }
//
//    @Test
//    void  update(){
//        User user = new User();
//        user.setId(1L);
//        user.setName("Tom666");
//        userMapper.updateById(user);
//    }
//
//    @Test
//    void testGetById(){
//        User user = userMapper.selectById(2L);
//        System.out.println(user);
//    }
//
//
//    @Test
//    void testGetAll() {
//        List<User> users = userMapper.selectList(null);
//        System.out.println(users);
//    }
//
//
//    @Test
//    void testGetByPage(){
//        IPage page = new Page(2,3);   //代表第几页，二代表这一页多少条
//        userMapper.selectPage(page,null);
//        System.out.println("当前页码值:"+page.getCurrent());
//        System.out.println("每页显示数:"+page.getSize());
//        System.out.println("一共多少页:"+page.getPages());
//        System.out.println("一共多少条数据："+page.getTotal());
//        System.out.println("数据："+page.getRecords());
//    }

    //    demo2
//    @Test
//    void testGetAll() {
//        //方式一：按条件查询
//        QueryWrapper wrapper = new QueryWrapper();
////        小于lt，第一个设置字段，第二个设置数值
//        wrapper.lt("age",18);
//        List<User> users = userMapper.selectList(wrapper);
//        System.out.println(users);


//        方式二：Lambda格式按条件查询
//        QueryWrapper<User> wrapper = new QueryWrapper<User>();
//        wrapper.lambda().lt(User::getAge,10);
//        List<User> users = userMapper.selectList(wrapper);
//        System.out.println(users);

//        方式三：Lambda格式按条件查询
//        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>();
//        wrapper.lt(User::getAge, 10);
//        List<User> users = userMapper.selectList(wrapper);
//        System.out.println(users);

//        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>();
////        10-30
////        wrapper.lt(User::getAge, 30).gt(User::getAge,10);
////        <10 or >30
//        wrapper.lt(User::getAge, 10).or().gt(User::getAge,30);
//        List<User> users = userMapper.selectList(wrapper);
//        System.out.println(users);


//       模拟页面传递过来的查询数据
//        UserQuery userQuery = new UserQuery();
////        userQuery.setAge(10);
//        userQuery.setAge2(30);

//        null判定
//        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>();
//        wrapper.lt(User::getAge2, userQuery.getAge2());
//        if(null!=userQuery.getAge()) {
//            wrapper.gt(User::getAge, userQuery.getAge());
//        }
//        List<User> users = userMapper.selectList(wrapper);
//        System.out.println(users);

//        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>();
//        wrapper.lt(User::getAge, userQuery.getAge2());
////        先判断第一个条件是否为true，如果为false，则不连接此条件
//        wrapper.gt(null!=userQuery.getAge(),User::getAge, userQuery.getAge());
//        wrapper.lt(null!=userQuery.getAge2(),User::getAge, userQuery.getAge2());
//        List<User> users = userMapper.selectList(wrapper);
//        System.out.println(users);


//    查询投影
//        lambda格式
//        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>();
////        设置查看哪些，未算则的赋值null
//        wrapper.select(User::getId,User::getName,User::getAge);
//        普通格式中条件为字符串
//        QueryWrapper<User> wrapper = new QueryWrapper<User>();
//        wrapper.select("id","name","age");
//        List<User> users = userMapper.selectList(wrapper);
//        System.out.println(users);

//        QueryWrapper<User> wrapper = new QueryWrapper<User>();
////        查总数
//        wrapper.select("count(*) as count, age");
////        分组
//        wrapper.groupBy("age");
//        List<Map<String, Object>> userList = userMapper.selectMaps(wrapper);
//        System.out.println(userList);


//        条件查询
//        1.==
//        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>();
//        wrapper.eq(User::getName,"Jerry").eq(User::getPassword,"jerry");
//        User user = userMapper.selectOne(wrapper);
//        System.out.println(user);

//        2.范围查询 ，lt gt 不带= ，le,ge 带= eq =  between
//        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>();
////        前小 后大
//        wrapper.between(User::getAge,10,30);
//        List<User> users = userMapper.selectList(wrapper);
//        System.out.println(users);

//        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>();
////        模糊匹配
////        likeLeft  likeRight 表示%在哪边
//        wrapper.like(User::getName,"J");
//        List<User> users = userMapper.selectList(wrapper);
//        System.out.println(users);
//
//        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>();
//        List<User> users = userMapper.selectList(wrapper);
//        System.out.println(users);
//    }


    //        demo3
//    @Test
//    void testSave() {
//        User user = new User();
////        user.setId(5L);
//        user.setName("黑马程序员");
//        user.setPassword("itcast");
//        user.setAge(13);
//        user.setTel("12312312312");
//        userMapper.insert(user);
//    }

//    @Test
//    void testDelete() {
//        多个删除
//        List<Long> list = new ArrayList<Long>();
//        list.add(1598945298917421057L);
//        list.add(1598945298917421058L);
//        list.add(7L);
//        list.add(6L);
//        userMapper.deleteBatchIds(list);

//        查询多个
//        List<Long> list = new ArrayList<Long>();
//        list.add(1L);
//        list.add(2L);
//        userMapper.selectBatchIds(list);

//        将id=1的deleted 设置为1，表示已经删除
//        userMapper.deleteById(1L);
//        不会查询deleted = 1 的数据
//        System.out.println(userMapper.selectList(null));

//        userMapper.deleteById(2L);
//    }

//    @Test
//    void testUpdate() {
//        User user = new User();
//        user.setId(3L);
//        user.setName("Joker888");
//        user.setPassword("joker888");
//        user.setVersion(1);
//        userMapper.updateById(user);

//        1.先通过id查询数据
//        User user = userMapper.selectById(3L);
//        user.setName("Joker");
//        user.setPassword("joker");
//        userMapper.updateById(user);

//        User user = userMapper.selectById(3L);    //version = 3
//        User user2 = userMapper.selectById(3L);   //version = 3
//
//        user2.setName("Joker66");
//        userMapper.updateById(user);         //version = 4
//
//        user.setName("Joker88");
//        userMapper.updateById(user);
//    }


//    demo4
@Test
public void test(){

}

}

