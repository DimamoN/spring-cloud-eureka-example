package com.dimamon.newsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
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
}
