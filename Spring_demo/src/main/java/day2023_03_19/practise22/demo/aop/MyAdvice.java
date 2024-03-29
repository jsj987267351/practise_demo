package day2023_03_19.practise22.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class MyAdvice {
    @Pointcut("execution(* day2023_03_19.practise22.demo.dao.BookDao.findName(..))")
    private void pt(){}

    //JoinPoint：用于描述切入点的对象，必须配置成通知方法中的第一个参数，可用于获取原始方法调用的参数
//    @Before("pt()")
    public void before(JoinPoint jp) {
        Object[] args = jp.getArgs();    //获取参数
        System.out.println(Arrays.toString(args));
        System.out.println("before advice ...");
    }

//    @After("pt()")
    public void after(JoinPoint jp) {
        Object[] args = jp.getArgs();    //获取参数
        System.out.println(Arrays.toString(args));
        System.out.println("after advice ...");
    }

    //ProceedingJoinPoint：专用于环绕通知，是JoinPoint子类，可以实现对原始方法的调用
//    @Around("pt()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();   //获取参数
        System.out.println(Arrays.toString(args));
        args[0] = 666;

        Object ret = pjp.proceed(args);   //获取返回值
        return ret;
    }


//    @Around("pt()")  //异常拿数据
//    public Object around(ProceedingJoinPoint pjp)  {
//        Object[] args = pjp.getArgs();   //获取参数
//        System.out.println(Arrays.toString(args));
//        args[0] = 666;
//
//        Object ret = null;   //获取返回值
//        try {
//            ret = pjp.proceed(args);
//        } catch (Throwable e) {     //e就是异常
//            e.printStackTrace();
//        }
//        return ret;
//    }

    //设置返回后通知获取原始方法的返回值，要求returning属性值必须与方法形参名相同
//    @AfterReturning(value = "pt()" ,returning = "ret")   //returning获取返回值
    public void afterReturning(JoinPoint jp,Object ret) {      //JoinPoint 必须放在参数的第一位
        System.out.println("afterReturning advice ..."+ret);
    }

    //设置抛出异常后通知获取原始方法运行时抛出的异常对象，要求throwing属性值必须与方法形参名相同
    @AfterThrowing(value = "pt()",throwing = "t")
    public void afterThrowing(Throwable t) {
        System.out.println("afterThrowing advice ..."+t);
    }
}
