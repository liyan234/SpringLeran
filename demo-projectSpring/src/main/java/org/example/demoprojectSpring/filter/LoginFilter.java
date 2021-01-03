package org.example.demoprojectSpring.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.demoprojectSpring.domain.User;
import org.example.demoprojectSpring.serivce.impl.UserServiceImpl;
import org.example.demoprojectSpring.utils.JsonData;
import org.thymeleaf.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebFilter( urlPatterns = "/api/v1/pri/*", filterName = "LoginFilter")
public class LoginFilter implements Filter {
    ObjectMapper ob = new ObjectMapper();
    /**
     * 在 启动类启动的时候 就会创建
     * */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");
    }

    /**
     * 当有对应的url被访问的时候
     * doFilter方法就会被调用
     * 用里面的代码来实现对应的拦截
    * */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("do filter");
        // 1. 强转类型
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        // 2. 然后用方法判断是否可以通过
        // 通过则控制chain.doFilter的方法的调用，来实现是否通过放行
        //通过则调用filterChain.doFilter(servletRequest, servletResponse); 放行
        //不通过 则让返回一个json字符串
        // 或者调用resp.sendRedirect()方法 让其返回一个页面

        String token = req.getHeader("token");
        if(StringUtils.isEmpty(token)) {
            token = req.getParameter("token");
        }

        if(!StringUtils.isEmpty(token)) {
            User user = UserServiceImpl.sessionMap.get(token);

            if(user != null) {
                filterChain.doFilter(servletRequest, servletResponse);
              } else {

                JsonData jsonData =  JsonData.buildError(-2,"登录失败， token无效" );
                String jsonStr = ob.writeValueAsString(jsonData);
                renderJson(resp, jsonStr);
            }
        } else {
            JsonData jsonData =  JsonData.buildError(-3,"未登录" );
            String jsonStr = ob.writeValueAsString(jsonData);
            renderJson(resp, jsonStr);
        }

    }

    private void renderJson(HttpServletResponse response, String json) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        try (PrintWriter w = response.getWriter()){
            // 用 try 包裹住 就可以自动关闭输入输出流
            w.print(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 当结束的时候 filter随之摧毁，就会调用destroy方法
     * */

    @Override
    public void destroy() {

    }
}
