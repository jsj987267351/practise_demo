package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * urlApattern:一个Servlet可以配置多个访问路径
 * 信息匹配：
 *      请确匹配；“/user/select”
 *      目录匹配：“/user/*”
 *      扩展名匹配：“*。do”     前面不能加/
 *      /*    /
 */
@WebServlet(urlPatterns = "/user/select")
public class demo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo4...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
