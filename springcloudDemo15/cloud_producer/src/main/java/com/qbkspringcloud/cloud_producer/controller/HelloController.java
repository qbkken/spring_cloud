package com.qbkspringcloud.cloud_producer.controller;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/hello")
    public String index(@RequestParam String name) {
        return "hello "+name+"，this is first messge";
    }


    @RequestMapping("/exError")
    public String exceError (@RequestParam String name) {

        logger.info("request exceError is "+name);
       if(StringUtils.isNotBlank(name)){
           throw new RuntimeException();
       }
        return "hello "+name+"，this is two messge";
    }

    @RequestMapping("/retry")
    public String retry(@RequestParam String name) {
        logger.info("request retry is "+name);
        try{
            Thread.sleep(1000000);
        }catch ( Exception e){
            logger.error(" hello two error",e);
        }
        return "hello "+name+"，this is two messge";
    }
}