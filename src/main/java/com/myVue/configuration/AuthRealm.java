package com.myVue.configuration;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.myVue.bean.UserEntity;
import com.myVue.service.UserService;

public class AuthRealm extends AuthorizingRealm {
	
	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private UserService userService;

	// 认证.登录
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken utoken = (UsernamePasswordToken) token;// 获取用户输入的token
		String username = utoken.getUsername();
		UserEntity user = userService.getUserByUserId(username);
		return new SimpleAuthenticationInfo(user, user.getPassWord(), this.getClass().getName());// 放入shiro.调用CredentialsMatcher检验密码
	}

	// 授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		List<String> permissions=new ArrayList<>();
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		/*
		 * Set<Role> roles = user.getRoles();
		if (roles.size() > 0) {
			for (Role role : roles) {
				Set<Module> modules = role.getModules();
				if (modules.size() > 0) {
					for (Module module : modules) {
						permissions.add(module.getMname());
					}
				}
			}
		}
		 */
        info.addStringPermissions(permissions);//将角色权限放入shiro中.
        return info;
	}

}