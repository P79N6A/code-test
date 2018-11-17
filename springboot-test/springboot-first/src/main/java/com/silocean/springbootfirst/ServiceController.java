package com.silocean.springbootfirst;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author siyunfei
 * 2018/11/17 2:51 PM
 */
@RestController
@RequestMapping("api-service")
public class ServiceController {
    private static final Logger logger = LoggerFactory.getLogger(ServiceController.class);

    @RequestMapping("/hello")
    public String apiGet() throws Exception {
        logger.info("======hello======");
        Response response = null;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("http://localhost:9999/child-service/hello").build();
        response = client.newCall(request).execute();
        return response.body().string();
    }
}
