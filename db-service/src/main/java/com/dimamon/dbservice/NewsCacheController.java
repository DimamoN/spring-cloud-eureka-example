package com.dimamon.dbservice;

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

}
