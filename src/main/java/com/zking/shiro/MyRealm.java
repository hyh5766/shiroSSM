package com.zking.shiro;

import com.zking.model.User;
import com.zking.service.IUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class MyRealm extends AuthorizingRealm {
@Autowired

   private IUserService userService;
    //权限验证
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = principalCollection.getPrimaryPrincipal().toString();
        Set<String> roles = userService.getRoleByUserName(username);
        Set<String> permissions = userService.getPermissionByUserName(username);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            // 设置用户角色信息
          info.setRoles(roles);
          //设置用户的权限信息
        info.setStringPermissions(permissions);

        return info;
    }

    //用户的身份验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
           //得到前端用户输入的用户名
        String username = authenticationToken.getPrincipal().toString();
        
        //根据用户名得到用户的所有信息
        User user = userService.selectByUserName(username);

        //盐加密  拿到数据源 得到用户的信息 并且保存起来 然后就拿到了账号和密码
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getUsername(),
                user.getPassword(), ByteSource.Util.bytes(user.getSalt()),this.getName());

        return info;
    }
}
