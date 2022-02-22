//package com.jiang.websocket.filter;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//
///**
// * @desc 自定义过滤器，可以在这里处理中文乱码等问题
// * @Author wangsh
// * @date 2018/5/6 15:44
// * @return
// */
//public class CharacterFilter implements Filter {
//
//   /**
//    * 服务启动,调用初始化方法
//    *
//    * @param filterConfig
//    * @throws ServletException
//    */
//   @Override
//   public void init(FilterConfig filterConfig) throws ServletException {
//
//      System.out.println("服务启动,调用过滤器Filter初始化方法init()..........");
//   }
//
//
//   /**
//    * 请求时调用
//    *
//    * @param request
//    * @param response
//    * @param filterChain
//    * @throws IOException
//    * @throws ServletException
//    */
//   @Override
//   public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
//
//      System.out.println("发送请求时,调用过滤器Filter的doFilter()方法..........");
//      request=(HttpServletRequest)request;
//
//      //放行通过
//      filterChain.doFilter(request, response);
//   }
//
//   /**
//    * 销毁调用
//    */
//   @Override
//   public void destroy() {
//
//      System.out.println("服务关闭，调用过滤器Filter的销毁方法destroy()..........");
//   }
//}
