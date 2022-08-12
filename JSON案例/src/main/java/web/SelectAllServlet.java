package web;

import com.alibaba.fastjson.JSON;
import pojo.Brand;
import service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    private BrandService service = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用service查询
        List<Brand> brands = service.selectAll();

        //2.将集合转换为JSON数据  序列化
        String json = JSON.toJSONString(brands);

        //3.响应
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(json);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);

    }
}
