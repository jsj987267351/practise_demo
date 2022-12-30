package springboot_dev.day01.SSMP.controller;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//异常处理器
//@RestControllerAdvice
public class ProjectExceptionAdvice {


//    拦截所有异常信息
//    @ExceptionHandler
    public Result doException(Exception e){
        e.printStackTrace();
        return new Result("服务器故障");
    }
}
