package ru.pcs.web.securiry.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsService userDetailsServiceImpl;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                    .antMatchers("/signUp").permitAll()
                    .antMatchers("/").authenticated()
                    .antMatchers("/profile").authenticated()
                    .antMatchers("/users/**").hasAuthority("ADMIN")
                    .antMatchers("/products/**").hasAuthority("ADMIN")
                    .antMatchers("/product/**").hasAuthority("ADMIN")
                    .and()
                .formLogin()
                    .loginPage("/signIn")
                    .defaultSuccessUrl("/profile")
                    .usernameParameter("email")
                    .passwordParameter("password")
                    .and()
                .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/signIn?logout")
                    .deleteCookies("JSESSIONID")
                    .invalidateHttpSession(true);
    }
}
