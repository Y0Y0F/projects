package com.project.author2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @Description: 资源服务器： 继承ResourceServerConfigurerAdapter，并使用@EnableResourceServer注解开启资源服务器配置。
 * resourceId()来配置资源id，这里的id和授权服务器的资源id要一样。 stateless()方法设置这些资源仅基于令牌验证。
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
  @Override
  public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
    resources.resourceId("rid").stateless(true);
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/admin/**")
        .hasRole("admin")
        .antMatchers("/user/**")
        .hasRole("user")
        .anyRequest()
        .authenticated();
  }
}
