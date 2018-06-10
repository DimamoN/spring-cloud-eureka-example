package com.dimamon.dbservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/db")
public class NewsCacheController {

    /**
     * Mock endpoint
     * @param id article id
     * @return fake article
     */
    @RequestMapping("/{articleId}")
    public String getArticle(@PathVariable("articleId") String id){
        return "Article: " + id;
    }


    // Endpoints to get properties from configuration server //

    @RequestMapping("/property1")
    public String getParamOne(@Value("${db.param.one}") String param){
        return param;
    }

    @RequestMapping("/property2")
    public String getParamTwo(@Value("${db.param.two}") String param){
        return param;
    }

    @RequestMapping("/property3")
    public String getParamThree(@Value("${param.one}") String param){
        return param;
    }

}
