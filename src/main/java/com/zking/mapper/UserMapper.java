package com.zking.mapper;

import com.zking.model.User;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


    //根据用户名进行登录
       public User selectByUserName(String username);

       //根据用户名获取到用户名信息
    public Set<String> getRoleByUserName(String username);

    //根据用户名获取到用户的权限信息
    public Set<String> getPermissionByUserName(String username);

    //查询用户的所有信息

    List<User> list();





}