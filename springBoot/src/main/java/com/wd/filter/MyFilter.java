package com.wd.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by aaa on 2017/4/14.
 * 使用注解标注过滤器
 *
 * @WebFilter将一个实现了javax.servlet.Filter接口的类定义为过滤器 属性filterName声明过滤器的名称, 可选
 * 属性urlPatterns指定要过滤 的URL模式,也可使用属性value来声明.(指定要过滤的URL模式是必选属性)
 * <p>
 * * 启动过程：
 * ServletContex初始化
 * Apache Tomcat/8.0.30
 * 过滤器初始化
 * 服务启动后：
 * 执行过滤操作
 * Session 被创建
 * 销毁过程：
 * Session 被销毁
 * 过滤器销毁
 * ServletContex销毁
 */
@WebFilter(filterName = "myFilter", urlPatterns = "/*")
public class MyFilter implements Filter {
    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("执行过滤操作");
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }
}
