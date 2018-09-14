package org.numismat.springboot.config;

import org.numismat.springboot.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private final UserDetailService userDetailService;

    @Autowired
    public WebSecurityConfig(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()

                .antMatchers("/css/**", "/js/**", "/images/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/coins/all/**").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/api/coins/search/**").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/api/coins/edit**", "/api/coins/add**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/coins/delete/**").hasRole("ADMIN")
//              .antMatchers(HttpMethod.PUT, "/media/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/", true).permitAll()
//                .formLogin().permitAll()
                .and()
                .logout().permitAll()
                .and().csrf().disable();

    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }

}
