package com.example.sem4.config;

import com.example.sem4.service.UserService;
import com.example.sem4.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    UserService userService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService((UserDetailsService) userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**").csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/index", "/login", "/productDetail", "/about", "/products", "/cart", "/create_product", "/pay",
                        "/register", "/news", "/help", "/listnew","/updatenew", "/createnew", "/deletenew", "/adminIndex", "/updaterole","/listrole","/list").permitAll()
                .antMatchers("/css/**", "/js/**", "/images/**", "vendors/**").permitAll()
                .antMatchers("/adminIndex").hasAnyAuthority("ADMIN")
                .antMatchers("/profile").hasAnyAuthority("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login_security")
                .failureUrl("/login-error")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/default")
                .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/error");
    }
}
