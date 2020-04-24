package com.project.author2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @Description: 这里的HttpSecurity配置主要配置/oauth/**的URL，这一类的请求直接放行。
 * 在资源服务器配置中也有一个HttpSecurity，这里的HttpSecurity优先于资源服务器的HttpSecurity。
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Bean
  @Override
  protected UserDetailsService userDetailsService() {
    return super.userDetailsService();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
        .withUser("admin")
        .password("$2a$10$RMuFXGQ5AtH4wOvkUqyvuecpqUSeoxZYqilXzbz50dceRsga.WYiq")
        .roles("admin")
        .and()
        .withUser("sang")
        .password("$2a$10$RMuFXGQ5AtH4wOvkUqyvuecpqUSeoxZYqilXzbz50dceRsga.WYiq")
        .roles("user");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.antMatcher("/oauth/**")
        .authorizeRequests()
        .antMatchers("/oauth/**")
        .permitAll()
        .and()
        .csrf()
        .disable();
  }
}
