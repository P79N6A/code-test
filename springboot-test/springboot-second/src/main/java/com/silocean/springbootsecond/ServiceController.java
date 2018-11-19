package com.silocean.springbootsecond;

import brave.http.HttpTracing;
import com.iqiyi.rover.okhttp3.TracingCallFactory;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author siyunfei
 * 2018/11/17 2:51 PM
 */
@RestController
@RequestMapping("child-service")
public class ServiceController {
    private static final Logger logger = LoggerFactory.getLogger(ServiceController.class);

    @Autowired
    HttpTracing httpTracing;

    @RequestMapping("/hello")
    public String apiGet() throws Exception {
        logger.info("======child service======");
        Response response = null;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("http://localhost:3458/child2-service/hello").build();
        Call.Factory callFactory = TracingCallFactory.create(httpTracing, client);
        response = callFactory.newCall(request).execute();
        return response.body().string();
    }
}
