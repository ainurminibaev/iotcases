package ru.jblab.iotcases.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
@ComponentScan(basePackages = {
        "ru.jblab.iotcases.auth"
})
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
//
//        http.exceptionHandling().accessDeniedPage("/forbidden");
//
//        http.authorizeRequests()
//                .antMatchers("/user/edit/**").authenticated()
//                .antMatchers("/user/**").authenticated();
////        http.authorizeRequests().antMatchers("/user/edit/**").hasAnyRole("ADMIN");
////        http.authorizeRequests().antMatchers("/user/edit**").hasAnyRole("ADMIN");
//        http.authorizeRequests()
//                .antMatchers("/events/add").hasAnyRole("ADMIN")
//                .regexMatchers("/events/[0-9]+/managers").authenticated()
//                .antMatchers("/events/**").authenticated();
////        http.authorizeRequests().antMatchers("/events/add").hasAnyRole("ADMIN");
////        http.authorizeRequests().antMatchers("/events/marksByStudent").hasAnyRole("ADMIN", "ELDER", "STUDENT");
////        http.authorizeRequests().antMatchers("/events/removeMark").hasAnyRole("ADMIN", "ELDER", "STUDENT");
////        http.authorizeRequests().antMatchers("/events/addToEvent").hasAnyRole("ADMIN", "ELDER", "STUDENT");
//
//        http.authorizeRequests().antMatchers("/managers/**").hasRole("ADMIN");
//
//        http.authorizeRequests().antMatchers("/register").hasAnyRole("ADMIN");
//        http.authorizeRequests().antMatchers("/user/delete").hasAnyRole("ADMIN");
//
//        http.authorizeRequests()
//                .antMatchers("/autocomplete/**").authenticated();
////        http.authorizeRequests().antMatchers("/autocomplete/studentsByGroup").hasAnyRole("ADMIN", "ELDER", "STUDENT");
////        http.authorizeRequests().antMatchers("/autocomplete/managersByGroup").hasAnyRole("ADMIN", "ELDER", "STUDENT");
//
//        http.authorizeRequests().antMatchers("/addParticipant").authenticated();
//        http.authorizeRequests().antMatchers("/resolveParticipant").authenticated();
//
//        http.authorizeRequests().antMatchers("/download/**").hasRole("ADMIN");
//
//        http
//                .formLogin()
//                .failureUrl("/login?error=true")
//                .loginPage("/login")
//                .permitAll()
//                .and()
//                .logout().logoutUrl("/logout")
//                .permitAll();
    }

    @Configuration
    protected static class AuthenticationConfiguration extends
            GlobalAuthenticationConfigurerAdapter {
        @Autowired
        AuthenticationProvider authenticationProvider;

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            auth.authenticationProvider(authenticationProvider);
        }

    }
}