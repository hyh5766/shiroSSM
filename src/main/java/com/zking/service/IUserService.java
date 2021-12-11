package com.zking.service;

import com.zking.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Transactional
public interface IUserService {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


       public User selectByUserName(String username);

    //根据用户名获取到用户名信息
    public Set<String> getRoleByUserName(String username);

    //根据用户名获取到用户的权限信息
    public Set<String> getPermissionByUserName(String username);

    //查询用户的所有信息
    List<User> list();


}