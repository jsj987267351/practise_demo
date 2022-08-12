package web;

import pojo.User;
import service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        User user = service.login(username, password);
        if (user != null) {
            //判断用户是否勾选记住我
            if("1".equals(remember)){
                Cookie c_cookie = new Cookie("username",username);
                Cookie p_cookie = new Cookie("password",password);

                c_cookie.setMaxAge(60*60*24*7);
                p_cookie.setMaxAge(60*60*24*7);

                response.addCookie(c_cookie);
                response.addCookie(p_cookie);
            }
            //登录成功
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath + "/selectAllServlet");
        } else {
            //登录失败
            //存储错误信息到request
            request.setAttribute("login_msg", "用户名或密码错误");
            //跳转login.jsp
            request.getRequestDispatcher("/login.jsp").forward(request, response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);

    }
}
