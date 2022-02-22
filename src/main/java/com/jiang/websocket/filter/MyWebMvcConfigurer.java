//package com.jiang.websocket.filter;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.socket.config.annotation.EnableWebSocket;
//
//@Configuration
//public class MyWebMvcConfigurer implements WebMvcConfigurer {
//    static final String ORIGINS[]=new String[] {"GET","POST","PUT","DELETE"};
//    @Override
//    public void addCorsMappings(CorsRegistry registry){
//            registry.addMapping("/**")
//                    //.allowedOriginPatterns("*")
//                    .allowedOrigins("Origin")
//                    .allowCredentials(true)
//                    .allowedMethods(ORIGINS)
//                    .maxAge(3600);
//    }
//
//
//}
