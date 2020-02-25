package com.springbootadmin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
public class SecuritySecureConfig extends WebSecurityConfigurerAdapter {

    //@Autowired
    //private CustomUserDetailService customUserDetailService;

    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        SavedRequestAwareAuthenticationSuccessHandler successHandler
                = new SavedRequestAwareAuthenticationSuccessHandler();

        successHandler.setTargetUrlParameter("redirectTo");
        successHandler.setDefaultTargetUrl("/");

        http.authorizeRequests()
            .antMatchers("/assets/**").permitAll()
            .antMatchers("/login").permitAll()
            .anyRequest().authenticated().and()
            .formLogin().loginPage("/login")
            .successHandler(successHandler).and()
            .logout().logoutUrl("/logout").and()
            .httpBasic().and()
            .csrf()
            .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
            .ignoringAntMatchers(
                    "/instances",
                    "/actuator/**"
            );
    }

    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.authenticationProvider(customAuthenticationProvider);
        //builder.userDetailsService(customUserDetailService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
