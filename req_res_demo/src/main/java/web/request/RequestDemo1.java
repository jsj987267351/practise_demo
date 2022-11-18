package web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;


@WebServlet("/req1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //方法 get
        String method = req.getMethod();
        System.out.println(method);
        //访问路径
        String contextPath = req.getContextPath();
        System.out.println(contextPath);
        //统一资源定位符
        StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURL.toString());
        //统一资源标识符
        String requestURI = req.getRequestURI();
        System.out.println(requestURI);
        //请求参数
        String queryString = req.getQueryString();
        System.out.println(queryString);
         //获取请求头  user-agent 浏览器的版本信息
        String header = req.getHeader("user-agent");
        System.out.println(header);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取post的请求体：请求参数
        BufferedReader br = req.getReader();
        String line = br.readLine();
        System.out.println(line);
    }
}
