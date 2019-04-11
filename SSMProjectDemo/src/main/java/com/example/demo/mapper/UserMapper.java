package com.example.demo.mapper;

import com.example.demo.entity.Tag;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    User checkUser(@Param("username") String username, @Param("password") String password);
    User getUserInfo(int userId);
    List<Tag> getFavoriteTags(int userId);
    List<User> getFollowings(int userId);
    List<User> getFollowers(int userId);
}
