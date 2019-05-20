package org.apache.struts.crud;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests()
                .antMatchers("/*").permitAll()
                .antMatchers("/actuator/info", "/edit/*", "/add").authenticated()
        .anyRequest().authenticated()
        .and()
        .httpBasic();
    }
}
