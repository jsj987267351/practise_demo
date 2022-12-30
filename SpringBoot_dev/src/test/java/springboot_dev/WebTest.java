package springboot_dev;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.HeaderResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

import javax.print.attribute.standard.MediaSize;

//运用web环境启动，用来测试web方面
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//开启虚拟MVC调用
@AutoConfigureMockMvc
public class WebTest {

    @Test
    void test(@Autowired MockMvc mvc) throws Exception {
//        创建虚拟请求，当前访问/books
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
//        执行对应请求
        mvc.perform(builder);
    }

    @Test
    void testStatus(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions action = mvc.perform(builder);
//        设定预期值，与真实值进行比较，成功测试通过，失败测试失败
//        定义本次调用的预期值
        StatusResultMatchers status = MockMvcResultMatchers.status();
//        预计本次调用是成功的：状态200
        ResultMatcher ok = status.isOk();
//        添加预期值刀本次调用过程中进行匹配
        action.andExpect(ok);

    }
    
    @Test
    void testBody(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions action = mvc.perform(builder);
//        设定预期值，与真实值进行比较，成功测试通过，失败测试失败
//        定义本次调用的预期值
        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher result = content.string("springboot");
//        添加预期值刀本次调用过程中进行匹配
        action.andExpect(result);
    }

    @Test
    void testJson(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions action = mvc.perform(builder);
//        设定预期值，与真实值进行比较，成功测试通过，失败测试失败
//        定义本次调用的预期值
        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher result = content.json("{\"id\":1,\"type\":\"springboot\",\"name\":\"springboot\",\"description\":\"springboot\"}");
//        添加预期值刀本次调用过程中进行匹配
        action.andExpect(result);
    }

    @Test
    void testContentType(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions action = mvc.perform(builder);
//        设定预期值，与真实值进行比较，成功测试通过，失败测试失败
//        定义本次调用的预期值
        HeaderResultMatchers header = MockMvcResultMatchers.header();
        ResultMatcher result = header.string("Content-Type", "application/json");
//        添加预期值刀本次调用过程中进行匹配
        action.andExpect(result);
    }


//    Web标准测试写完，定义一个测试一个
    @Test
    void testGetById(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions action = mvc.perform(builder);

        StatusResultMatchers status = MockMvcResultMatchers.status();
        ResultMatcher ok = status.isOk();
        action.andExpect(ok);

        HeaderResultMatchers header = MockMvcResultMatchers.header();
        ResultMatcher result = header.string("Content-Type", "application/json");
        action.andExpect(result);

        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher result2 = content.json("{\"id\":1,\"type\":\"springboot\",\"name\":\"springboot\",\"description\":\"springboot\"}");
        action.andExpect(result2);
    }




}
