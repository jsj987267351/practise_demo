package web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
            //加载资源
        System.out.println("监听器执行");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

        //销毁资源

    }
}
