package com.dimamon.newsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@ConfigurationProperties // adds support for properties from spring-config-server
@RequestMapping("/rest/search")
public class NewsSearchController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{articleName}")
    public String searchForArticle(@PathVariable("articleName") String articleName,
                                   @Value("${server.port}") String port){

        // some cool logic here
        // for example: check if there are such article in db, if there no -> try to search on web.

        String text = " [found by " +  port + "]";
        return restTemplate.getForObject("http://db-service/rest/db/" + articleName, String.class) + text;
    }


    // Endpoint to get user.home param value //

    @RequestMapping("/userhome")
    public String getUserhome(@Value("${user.home}") String userhome){
        return userhome;
    }


    // Endpoints to get properties from configuration server //

    @RequestMapping("/property1")
    public String getParamOne(@Value("${news.param.one}") String param){
        return param;
    }

    @RequestMapping("/property2")
    public String getParamTwo(@Value("${news.param.two}") String param){
        return param;
    }

    @RequestMapping("/property3")
    public String getParamThree(@Value("${param.one}") String param){
        return param;
    }

}
