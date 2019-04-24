package com.zgcwkj.role;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfiguration {

    //Session管理
    @Bean("sessionManager")
    public SessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        //sessionManager.setSessionIdCookieEnabled(false);
        return sessionManager;
    }

    //安全管理
    @Bean("securityManager")
    public SecurityManager securityManager(ShiroAuthRealm shiroAuthRealm, SessionManager sessionManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroAuthRealm);
        securityManager.setSessionManager(sessionManager);

        return securityManager;
    }

    //拦截管理
    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);
        shiroFilter.setLoginUrl("/admin/index");//登录界面
        shiroFilter.setSuccessUrl("/admin/admin");//后台界面
        shiroFilter.setUnauthorizedUrl("/403");// 未授权界面
        //过滤请求
        Map<String, String> filterMap = new LinkedHashMap<>();
        //==>资源文件放行
        filterMap.put("/css/**", "anon");
        filterMap.put("/fonts/**", "anon");
        filterMap.put("/img/**", "anon");
        filterMap.put("/js/**", "anon");
        filterMap.put("/layui/**", "anon");
        filterMap.put("/favicon.ico", "anon");
        //==>资源文件放行
        filterMap.put("/", "anon");//默认页面
        filterMap.put("/admin", "anon");//登陆页面
        filterMap.put("/admin/index", "anon");//登陆页面
        filterMap.put("/admin/validateImage", "anon");//验证码请求
        filterMap.put("/admin/login", "anon");//登陆请求
        filterMap.put("/admin/admin", "authc");//后台页面
        filterMap.put("/druid/**", "authc");//德鲁伊页面
        filterMap.put("/**", "authc");
        //自定义过滤
        //Map<String, Filter> filters = new HashMap<>();
        //filters.put("oauth2", new OAuth2Filter());
        //shiroFilter.setFilters(filters);
        //filterMap.put("/**", "oauth2");
        shiroFilter.setFilterChainDefinitionMap(filterMap);
        return shiroFilter;
    }

    //配置 Shiro 跟 Spring 关联
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

    //Spring 的一个 Bean , 由 Advisor 决定对哪些类的方法进行 AOP 代理
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
        proxyCreator.setProxyTargetClass(true);
        return proxyCreator;
    }

    //lifecycleBeanPostProcessor是负责生命周期的 , 初始化和销毁的类
    @Bean("lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }
}
