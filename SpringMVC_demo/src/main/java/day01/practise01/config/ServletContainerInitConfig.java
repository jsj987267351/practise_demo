//package day01.practise01.config;
//
//
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;
//
////4.定义一个servlet容器启动的配置类，在里面加载spring的配置
//public class ServletContainerInitConfig extends AbstractDispatcherServletInitializer {
//
////    加载springmvc容器配置
//    @Override
//    protected WebApplicationContext createServletApplicationContext() {
//        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
//        ctx.register(SpringMvcConfig.class);
//        return ctx;
//    }
//
////    配置哪些请求归属springMvc处理
//    @Override
//    protected String[] getServletMappings() {
//        return new String[]{"/"};
//    }
//
////    加载spring容器配置
//    @Override
//    protected WebApplicationContext createRootApplicationContext() {
//        return null;
//    }
//}
