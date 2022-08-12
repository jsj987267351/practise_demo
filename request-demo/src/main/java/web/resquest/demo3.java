package web.resquest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/demo3")
public class demo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决乱码  Post
//        request.setCharacterEncoding("utf-8");

        //解决乱码 Get
//        String username = request.getParameter("username");
//        System.out.println("解决乱码前:"+username);
//        byte[] bytes = username.getBytes(StandardCharsets.ISO_8859_1);
//        username = new String(bytes, StandardCharsets.UTF_8);
//        System.out.println("解决乱码后:"+username);

        String username = new String(request.getParameter("username").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        System.out.println("解决乱码后:"+username);





    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);

    }
}
