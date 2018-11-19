package com.silocean.springbootthird;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author siyunfei
 * 2018/11/17 2:51 PM
 */
@RestController
@RequestMapping("child2-service")
public class ServiceController {
    private static final Logger logger = LoggerFactory.getLogger(ServiceController.class);

    @RequestMapping("/hello")
    public String apiGet() {
        logger.info("======child2 service======");
        return "hello parent";
    }
}
