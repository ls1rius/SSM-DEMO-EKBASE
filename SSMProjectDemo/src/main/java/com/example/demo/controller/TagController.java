package com.example.demo.controller;

import com.example.demo.mapper.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TagController {

    @Autowired
    private TagMapper tagMapper;
    @RequestMapping("/getPopularTags")
    public Object getPopularTags() {
        return tagMapper.getPopularTags();
    }
}
