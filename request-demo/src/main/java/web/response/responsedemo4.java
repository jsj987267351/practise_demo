package web.response;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 响应字符数据
 */
@WebServlet("/resp4")
public class responsedemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\zheng\\Desktop\\a.jpg");


        ServletOutputStream outputStream = response.getOutputStream();
//        byte[] bytes = new byte[1024];
//        int len=0 ;
//        while((len=fileInputStream.read(bytes))!=-1){
//            outputStream.write(bytes,0,len);
//        }
        IOUtils.copy(fileInputStream,outputStream);
        fileInputStream.close();


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);

    }
}
