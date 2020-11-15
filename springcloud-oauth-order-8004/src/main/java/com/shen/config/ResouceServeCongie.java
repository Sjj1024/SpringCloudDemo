package com.shen.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

import java.rmi.Remote;

@Configuration
@EnableResourceServer
public class ResouceServeCongie extends ResourceServerConfigurerAdapter {

    // 配置资源ID
    public static final String RESOURCE_ID = "resource1";

    // // 配置令牌验证的服务
    // @Bean
    // public ResourceServerTokenServices tokenServices(){
    //     RemoteTokenServices services = new RemoteTokenServices();
    //     services.setCheckTokenEndpointUrl("http://localhost:8003/oauth/check_token");
    //     services.setClientId("client1");
    //     services.setClientSecret("secret");
    //     return services;
    // }

    // 注入本地验证的配置类
    @Autowired
    TokenStore tokenStore;

    // 配置资源服务
    @Override
    public void configure(ResourceServerSecurityConfigurer resources){
        resources.resourceId(RESOURCE_ID)
                // .tokenServices(tokenServices()) // 验证令牌的服务
                .tokenStore(tokenStore)  // 使用远程校验令牌的服务
                .stateless(true);
    }

    // 配置HTTP服务
    public void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests()
                .antMatchers("/**").access("#oauth2.hasScope('all')")
                .and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

}
