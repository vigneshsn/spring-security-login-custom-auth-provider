package com.vigneshsn.springlogindemo.security

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy

@Configuration
class SecurityConfig: WebSecurityConfigurerAdapter(){

    override fun configure(httpSecurity: HttpSecurity) {
        httpSecurity.
                csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
    }

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth!!.authenticationProvider(CustomLoginAuthenticationProvider())
//        auth!!.inMemoryAuthentication()
//                .withUser("admin")
//                .password("{noop}test")
//                .roles("")
    }
}