package com.lh.ekbase.mapper;

import com.lh.ekbase.entity.User;
import com.lh.ekbase.entity.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper
{
    User checkUserInfo(@Param("username") String username, @Param("password") String password);
    User checkUserName(@Param("username") String username);
    User getUserInfo(int userId);
    List<Tag> getFavoriteTags(int userId);
    List<User> getFollowings(int userId);
    List<User> getFollowers(int userId);
    void register(@Param("username") String username,@Param("password") String password,@Param("name") String name,@Param("email") String email,@Param("phone") String phone);
}
