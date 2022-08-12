package web.servlet;


import com.alibaba.fastjson.JSON;
import pojo.Brand;
import pojo.PageBean;
import service.BrandService;
import service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet{
    private BrandService brandService = new BrandServiceImpl();

    public void  selectAll(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        //1.调用service查询
        List<Brand> brands = brandService.selectAll();
        //2.转为JSON
        String jsontostring = JSON.toJSONString(brands);
        //3.写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsontostring);

    }

    public void  add(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        //1.接收品牌数据
        BufferedReader reader = req.getReader();
        String params = reader.readLine();  //json字符串
        Brand brand = JSON.parseObject(params, Brand.class);

        brandService.add(brand);

        resp.getWriter().write("success");

    }

    /**
     * 批量删除
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void  deleteByIds(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        //1.接收数据
        BufferedReader reader = req.getReader();
        String params = reader.readLine();  //json字符串

        //2.转为int类型的数组
        int[] ids = JSON.parseObject(params, int[].class);

        brandService.deleteByIds(ids);

        resp.getWriter().write("success");

    }

    /**
     * 分页查询
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void  selectByPage(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        //接收当前页码 和每页战术条数  url?currentPage=1&pageSize=5
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        PageBean<Brand> pageBean = brandService.selectByPage(currentPage, pageSize);
        String jsontostring = JSON.toJSONString(pageBean);

        //3.写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsontostring);

    }

    /**
     * 分页条件查询
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void  selectByPageAndCondition(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        //接收当前页码 和每页战术条数  url?currentPage=1&pageSize=5
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");

        //获取查询条件对象
        BufferedReader reader = req.getReader();
        String params = reader.readLine();  //json字符串

        //转为brand对象
        Brand brand = JSON.parseObject(params, Brand.class);

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        PageBean<Brand> pageBean = brandService.selectByPageAndCondition(currentPage, pageSize, brand);
        String jsontostring = JSON.toJSONString(pageBean);

        //3.写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsontostring);

    }

    public void  modify(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        String params = reader.readLine();  //json字符串

        Brand brand = JSON.parseObject(params, Brand.class);
        brandService.modify(brand);

        resp.getWriter().write("success");


    }


    public void  deleteById(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        String params = reader.readLine();  //json字符串

        Integer id = JSON.parseObject(params, int.class);
        brandService.deleteById(id);

        resp.getWriter().write("success");


    }

}
