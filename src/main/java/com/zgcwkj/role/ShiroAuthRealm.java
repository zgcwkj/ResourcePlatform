package com.zgcwkj.role;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zgcwkj.entity.Srole;
import com.zgcwkj.entity.Sroledetail;
import com.zgcwkj.entity.Suser;
import com.zgcwkj.service.ISroleService;
import com.zgcwkj.service.ISroledetailService;
import com.zgcwkj.service.ISuserService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ShiroAuthRealm extends AuthorizingRealm {

    @Autowired
    ISuserService iSuserService;
    @Autowired
    ISroleService iSroleService;
    @Autowired
    ISroledetailService iSroledetailService;

    /**
     * 角色验证
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取用户
        Suser suser = (Suser) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获取用户角色
        Srole srole = iSroleService.selectOne(new EntityWrapper<Srole>().eq("RoleID", suser.getRoleid()));
        Set<String> roleSet = new HashSet<>();
        roleSet.add(srole.getRolename());
        info.setRoles(roleSet);

        //获取用户权限
        List<Sroledetail> sroledetails = iSroledetailService.selectList(new EntityWrapper<Sroledetail>().eq("RoleID", suser.getRoleid()));
        Set<String> permissionSet = new HashSet<>();
        permissionSet.add("admin");
        for (Sroledetail sroledetail : sroledetails) {
            permissionSet.add(sroledetail.getBehavior());
        }
        info.setStringPermissions(permissionSet);

        return info;
    }

    /**
     * 身份验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken utoken = (UsernamePasswordToken) authcToken;// 获取用户输入的数据
        String username = utoken.getUsername();// 用户名称
        String password = String.valueOf(utoken.getPassword());// 用户密码
        if (username == null || "".equals(username)) {
            throw new LockedAccountException("未知错误");
        }
        Suser suser = iSuserService.selectOne(new EntityWrapper<Suser>().eq("Accounts", username));
        if (suser == null) {//判断账号
            throw new LockedAccountException("您输入的账号错误");
        }
        if (!suser.getPassword().equals(password)) {//判断密码
            throw new LockedAccountException("您输入的密码错误");
        }
        //第一个参数就是我们需要在保存在shiro中的session中的对象
        //第二参数是从数据库中查询出来的正确的密码，shiro会自动判断，如果此密码和刚才传递的密码不不匹配会抛异常
        //第三个参数是盐（可留空）
        //第四个参数是自定义的realm的名字，改方法可以重写自己随意更改
        return new SimpleAuthenticationInfo(suser, suser.getPassword(), this.getClass().getName());
    }
}