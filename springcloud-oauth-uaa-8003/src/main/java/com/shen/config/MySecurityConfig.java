package com.shen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Spring Security提供了一套基于内存的验证
        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin").password(new BCryptPasswordEncoder()
                .encode("123456")).roles("r1");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 决定那些请求被拦截
        http
                .authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/fonts/**", "/index").permitAll() //都可以访问
                // .antMatchers("").permitAll()// 主路径放行
                .anyRequest().permitAll()// 其他请求需经过验证
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .permitAll()// 表单登录允许任意权限访问
                .and()
                .logout().permitAll();// 注销操作允许任意权限访问
        http.csrf().disable();// 关闭默认的csrf认证
    }

    // @Override
    // public void configure(WebSecurity web) throws Exception {
    //     web.ignoring().antMatchers("/js'/**", "/css/**", "/images/**");// 对js、css、images不做拦截
    // }
}
