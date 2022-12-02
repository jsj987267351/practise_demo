package controller;

import exception.BusinessException;
import exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler(SystemException.class)
    public  Result  doSystemException(SystemException ex){
        //记录日志
        //发送消息给运费
        //发送邮件给开发人员,ex对象发送给开发人员
        return new Result(ex.getCode(),null,ex.getMessage());
    }


    @ExceptionHandler(BusinessException.class)
    public  Result  doBusinessException(BusinessException ex){
        //发送邮件给开发人员
        return new Result(ex.getCode(),null,ex.getMessage());
    }


    @ExceptionHandler(Exception.class)
    public  Result  doException(Exception e){
        //记录日志
        //发送消息给运费
        //发送邮件给开发人员,ex对象发送给开发人员
        return new Result(Code.SYSTEM_UNKNOWN_ERR,null,"系统繁忙，请稍后再试!");
    }

}