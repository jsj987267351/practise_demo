package web.resquest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.util.Map;

@WebServlet("/demo2")
public class demo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("Get...");
        Map<String, String[]> parameterMap = req.getParameterMap();
        for (String key:parameterMap.keySet()){
            System.out.print(key+":");
            String[] values = parameterMap.get(key);
            for (String value: values){
                System.out.print(value +" ");
            }
            System.out.println();
        }
        System.out.println("------------");
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby:hobbies){
            System.out.print(hobby);
        }
        System.out.println();
        System.out.println("------------");
        String username = req.getParameter("username");
        System.out.println(username);
        String password = req.getParameter("password");
        System.out.println(password);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doGet(req,resp);

    }
}
