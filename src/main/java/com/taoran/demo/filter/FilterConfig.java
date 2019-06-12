package com.taoran.demo.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class FilterConfig {

    public FilterRegistrationBean someFilterRegistration() {

        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(sessionFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.addInitParameter("paramName","paramValue");
        registrationBean.setName("encondingFilter");

        return registrationBean;
    }

    @Bean(name = "encondingFilter")
    public Filter sessionFilter(){
        return new EncodingFilter();
    }


}
