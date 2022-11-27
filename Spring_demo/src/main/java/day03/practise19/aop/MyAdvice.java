package day03.practise19.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {
    //切入点表达式：
        @Pointcut("execution(void day03.practise19.dao.BookDao.update())")         //接口
//    @Pointcut("execution(void day03.practise19.dao.impl.BookDaoImpl.update())")    //实现类
//    @Pointcut("execution(* day03.practise19.dao.impl.BookDaoImpl.update())")
//    @Pointcut("execution(void *.*.*.*.*.update())")   //*最少要有一个
//    @Pointcut("execution(void *..update())")    //..与*用法类似，但可为0.
//    @Pointcut("execution(void *..*e())")
//    @Pointcut("execution(void day03..*())")
    //执行day03.practise19包下的任意包下的名称以Service结尾的类或接口中的save方法，参数任意，返回值任意
//    @Pointcut("execution(* day03.practise19.*.*Service.save(..))")
    private void pt() {
    }

    @Before("pt()")
    public void method() {
        System.out.println(System.currentTimeMillis());
    }


}
