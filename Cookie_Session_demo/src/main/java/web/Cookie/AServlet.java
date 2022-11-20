package web.Cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/aServlet")
public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /**
         * 发送Cookie
         */

        //1 创建Cookie 对象
//        Cookie cookie = new Cookie("username","zs");

        //处理中文

        String value = "张朝证";

        //URL编码
        value = URLEncoder.encode(value, "utf-8");
        System.out.println(value);

        Cookie cookie = new Cookie("username",value);
        //设置存活时间   1周
        cookie.setMaxAge(60*60*24*7);

        //2 发送
        response.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);

    }
}
