package com.example.demo.mapper;


import com.example.demo.entity.Tag;

import java.util.List;

public interface TagMapper {
    List<Tag> getPopularTags();
}
