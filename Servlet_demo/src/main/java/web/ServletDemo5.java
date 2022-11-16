package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * urlPattern匹配 :
 *          *精确匹配:/user/demo5   全名与访问一致
 *          *目录匹配： /user/*
 *          *扩展名匹配:  *.do     不能以 / 开头
 *          *任意匹配： /   或/*     不要这样配置，会覆盖默认Servlet
 *          优先级:精确>目录>扩展名>任意
 */
@WebServlet(urlPatterns = "*.do")
public class ServletDemo5 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Get..");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Post..");
    }
}
