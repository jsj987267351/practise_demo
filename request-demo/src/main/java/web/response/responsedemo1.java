package web.response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 重定向
 */
@WebServlet("/resp1")
public class responsedemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("resp1");
        //设置响应状态码
//        response.setStatus(302);
        //设置响应头：location
//        response.setHeader("location","/request-demo/resp2");
        String contextPath = request.getContextPath();

        //简化方式
        response.sendRedirect(contextPath+"/resp2");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);

    }
}
