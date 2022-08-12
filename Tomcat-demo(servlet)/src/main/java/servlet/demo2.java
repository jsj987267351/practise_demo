package servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo2",loadOnStartup = 1)
public class demo2 implements Servlet {

    private ServletConfig config;
    /**
     *初始化方法
     *  第一次被访问时调用，只调用一次.
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
//        System.out.println("init...");
        this.config=servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    /**
     * 在Servlet被销毁时被调用
     * 1次
     */
    @Override
    public void destroy() {
//        System.out.println("destroy");

    }

    /**
     * 提供服务
     * 调用时机：每一次Servlet被调用时
     * 调用次数：多次
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Servlet Hello");

    }

    @Override
    public String getServletInfo() {
        return null;
    }

}
