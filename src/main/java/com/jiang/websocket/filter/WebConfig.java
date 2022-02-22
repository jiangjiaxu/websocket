//package com.jiang.websocket.filter;
//
//
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @desc 注册bean, 将自定义过滤器添加到过滤器链中
// * @Author wangsh
// * @date 2018/5/6 15:48
// * @return
// */
//@Configuration
//public class WebConfig {
//
//   /**
//    * 注册过滤器,有两种方式：
//    * 1) 使用 @Component 注解<br>
//    * 2) 添加到过滤器链中，此方式适用于使用第三方的过滤器。将过滤器写到 WebConfig 类中，如下：
//    */
//   @Bean
//   public FilterRegistrationBean filterRegistrationBean() {
//
//      FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//
//      CharacterFilter filter = new CharacterFilter();
//      registrationBean.setFilter(filter);
//
//      //设置过滤器拦截请求
//      List<String> urls = new ArrayList<>();
//      urls.add("/*");
//      registrationBean.setUrlPatterns(urls);
//
//      return registrationBean;
//   }
//
//}
