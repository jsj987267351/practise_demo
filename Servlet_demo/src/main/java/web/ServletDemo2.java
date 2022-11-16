package web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo2",loadOnStartup = 1)
public class ServletDemo2 implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        /**
         * 初始化
         * 只调用一次
         * 调用时机：默认情况，Servlet被第一次访问时，调用
         *     *LoadOnStartup:正整数时为访问前就调用
         */
        System.out.println("init");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello Servlet");

    }

    /**
     * 调用一次
     * 内存释放或者服务器关闭的时候，Servlet对象会被销毁，调用
     */
    @Override
    public void destroy() {
        System.out.println("Destroy");
    }


    /**
     * 获取Servlet相关信息，比如作者，版权。。。
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 获取Servlet配置对象
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
}
