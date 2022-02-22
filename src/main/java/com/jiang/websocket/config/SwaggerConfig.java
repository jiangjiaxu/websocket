package com.jiang.websocket.config;

import org.springframework.context.annotation.*;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;


@Configuration
@EnableSwagger2//开启swagger2 /swagger-ui.html
public class SwaggerConfig {
    //配置多个组
    @org.springframework.context.annotation.Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }
    @org.springframework.context.annotation.Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }

    //配置了swagger的Docket的bean实例
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("小旭")
                //是否自动打开
                //.enable(false);
                .select()
                //配置要扫描接口的方式,指定要扫描的包
                .apis(RequestHandlerSelectors.basePackage("com.jiang.swagger.controller"))
                //扫描指定包下的指定路径的方法
                //.paths(PathSelectors.ant("/jiang/**"))
                .build();
    }
    Contact contact=new Contact("xiaoxu","http://www.baidu.com","0");
    private ApiInfo apiInfo(){

        //作者信息
        return new ApiInfo("小旭学Swagger",
                "小旭学Swagger",
                "1.0",
                "http://www.baidu.com",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<springfox.documentation.service.VendorExtension>());
    }
}
