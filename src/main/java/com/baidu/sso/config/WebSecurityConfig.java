package com.baidu.sso.config;

import com.baidu.sso.JWTAuthenticationFilter;
import com.baidu.sso.JWTLoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.Collection;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // 自定义的AuthenticationProvider
    @Autowired
    private MyAuthenticationProvider provider;

    @Bean
    public PasswordEncoder myPasswordEncoder() {
        return new MyPasswordEncoder(); // 自定义的加密工具
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin().loginProcessingUrl("/login")
                .and()
                .csrf().disable()
                .addFilter(new JWTLoginFilter(authenticationManager()))
                .addFilter(new JWTAuthenticationFilter(authenticationManager()));
    }

    @Override

    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(provider);
        auth.userDetailsService(userDetailsService());
    }

    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager iud = new InMemoryUserDetailsManager();
        Collection<GrantedAuthority> adminAuth = new ArrayList<>();
        adminAuth.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        iud.createUser(new User("zhangsan","123456",adminAuth));
        return iud;
    }













}
