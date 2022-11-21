package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


@WebFilter("/*")
public class FilterDemo2 implements Filter {

    @Override
    public void doFilter(ServletRequest Request, ServletResponse Response, FilterChain Chain) throws IOException, ServletException {


        //放行前对request数据进行处理

        System.out.println("2.过滤器执行了");
        //放行
        Chain.doFilter(Request,Response);

        //放行后对response数据进行处理

        System.out.println("4.已经放行");

    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
