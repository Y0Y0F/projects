package com.project.author2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @Description: 授权服务器：
 * 继承AuthorizationServerConfigurerAdapter，完成对授权服务器的配置，然后通过@EnableAuthorizationServer注解开启授权服务器。
 * AuthenticationManager对象用来支持password授权模式。 RedisConnectionFactory对象用来完成redis的缓存。
 * UserDetailsService对象为刷新token提供支持。
 * authorizedGrantTypes()方法配置授权模式为password和refresh_token，其实在标准的oauth中并没有refresh_token，但是spring
 * security中将其归为一种，因此要实现access_token的刷新就需要refresh_token。 accessTokenValiditySeconds()方法设置token的过期时间。
 * resourceIds()方法配置资源id。 secret()方法配置了加密后的密码，明文是123。
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
  @Autowired AuthenticationManager authenticationManager;
  @Autowired RedisConnectionFactory redisConnectionFactory;
  @Autowired UserDetailsService userDetailsService;

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    clients
        .inMemory()
        .withClient("password")
        .authorizedGrantTypes("password", "refresh_token")
        .accessTokenValiditySeconds(1800)
        .resourceIds("rid")
        .scopes("all")
        .secret("$2a$10$RMuFXGQ5AtH4wOvkUqyvuecpqUSeoxZYqilXzbz50dceRsga.WYiq");
  }

  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    endpoints
        .tokenStore(new RedisTokenStore(redisConnectionFactory))
        .authenticationManager(authenticationManager)
        .userDetailsService(userDetailsService);
  }

  @Override
  public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
    security.allowFormAuthenticationForClients();
  }
}
