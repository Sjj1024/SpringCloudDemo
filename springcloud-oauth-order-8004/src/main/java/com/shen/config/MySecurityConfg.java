package com.shen.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class MySecurityConfg extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 决定那些请求被拦截
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/fonts/**", "/index").permitAll() //都可以访问
                .antMatchers("/order/**").authenticated() // 所有order下的请求都要认证
                .anyRequest().permitAll(); // 其他请求都可以访问
                // .and()
                // .formLogin()
                // .loginProcessingUrl("/login")
                // .permitAll()// 表单登录允许任意权限访问
                // .and()
                // .logout().permitAll();// 注销操作允许任意权限访问
    }
}
