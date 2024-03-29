package day2023_03_19.practise18.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//通知类必须配置成Spring管理的bean
@Component
//设置当前类为切面类类
@Aspect
public class MyAdvice {
    //设置切入点，要求配置在方法上方
    @Pointcut("execution(void day2023_03_19.practise18.dao.BookDao.update())")
    private void pt(){}

    //设置在切入点pt()的前面运行当前操作（前置通知）
    @Before("pt()")     //绑定
    public void method(){
        System.out.println(System.currentTimeMillis());      //通知
    }
}
