package com.silocean.springbootthird;

import brave.Tracing;
import brave.http.HttpTracing;
import brave.sampler.Sampler;
import com.iqiyi.rover.commons.RoverSpanLoggerReporter;
import com.iqiyi.rover.springmvc.DelegatingTracingFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import zipkin2.Span;
import zipkin2.reporter.Reporter;

/**
 * @author siyunfei
 * 2018/11/17 3:18 PM
 */
@Configuration
@EnableWebMvc
public class RoverConfig {
    @Bean
    public Tracing tracing(Reporter<Span> reporter) {
        return Tracing
                .newBuilder()
                .localServiceName("child2-service")                 // 填写当前程序的名称
                .projectID(12345)                              // 填写爱奇艺云所属项目的ID
                .spanReporter(reporter)
                .sampler(Sampler.create(1.0f))                  // 设置采样率；如果选择全采样，可以省略
                .build();
    }

    @Bean
    public Reporter<Span> loggerReporter() {
        return new RoverSpanLoggerReporter();
    }

    // 如果需要对HTTP请求做追踪，需要初始化HttpTracing对象
    // 包括作为HTTP客户端发送请求的情况（如使用RestTemplate），或作为HTTP服务端提供服务的情况（如SpringMVC等）
    @Bean
    public HttpTracing httpTracing(Tracing tracing) {
        return HttpTracing.create(tracing);
    }

    @Bean
    public FilterRegistrationBean roverFilterRegistrationBean() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new DelegatingTracingFilter());
        registration.addUrlPatterns("/*");
        registration.setName("roverFilter");
        registration.setOrder(1);
        return registration;
    }
}
