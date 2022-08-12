package web;

import com.alibaba.fastjson.JSON;
import pojo.Brand;
import service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/addAllServlet")
public class AddAllServletServlet extends HttpServlet {
    private BrandService service = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String brandName = request.getParameter("brandName");
//        System.out.println(brandName);

        //获取请求体数据
        BufferedReader reader = request.getReader();
        String s = reader.readLine();

        //将JSON字符串转为Java对象
        Brand brand = JSON.parseObject(s, Brand.class);

        //调用service添加
        service.add(brand);

        //响应成功标识
        response.getWriter().write("success");





    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);

    }
}
