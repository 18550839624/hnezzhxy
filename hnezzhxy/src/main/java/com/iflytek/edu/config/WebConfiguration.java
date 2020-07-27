package com.iflytek.edu.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * @author yq
 * @create 2020-07-14-11:16
 **/
@Configuration
public class WebConfiguration {
    //多个FilterRegistrationBean自定义过滤器，bean中的名字要不一样，不然会发生只会调用优先级最高的，优先级最低的不调用

    //@Bean("MyFilter") 相当于该方法中的setName()
    //@Order(6)目前不起作用
    @Bean
    public FilterRegistrationBean testFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());
        registration.addUrlPatterns("/test");//要过滤的路径
        registration.setName("MyFilter"); //过滤器的名字也是web容器中的实例对象名，也，可以不写这行，可以在bean注解
        registration.setOrder(6);//多个过滤器的执行顺序，数字越小优先级越高
        return registration;
    }

    //@Bean("MyFilter2") 相当于该方法中的setName()
    //@Order(6)目前不起作用
    @Bean
    public FilterRegistrationBean test2FilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter2());
        registration.addUrlPatterns("/test");
        registration.setName("MyFilter2");
        registration.setOrder(1);
        return registration;
    }
}
