package com.silocean.rovertest;

import brave.Tracing;
import brave.http.HttpTracing;
import com.iqiyi.rover.commons.RoverSpanLoggerReporter;
import com.iqiyi.rover.springmvc.DelegatingTracingFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by siyunfei on 2018/11/12.
 */
@Configuration
@EnableWebMvc
public class RoverConfig extends WebMvcConfigurerAdapter {
    @Bean
    public Tracing tracing() {
        return Tracing
                .newBuilder()
                .localServiceName("rover-demo")
                .projectID(114585)
                .spanReporter(new RoverSpanLoggerReporter())
                .build();
    }

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
