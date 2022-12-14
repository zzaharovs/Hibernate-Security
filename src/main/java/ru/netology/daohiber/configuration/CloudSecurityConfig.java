//package ru.netology.daohiber.configuration;
//
//import lombok.AllArgsConstructor;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.authentication.logout.LogoutFilter;
//import ru.netology.daohiber.security.PersonsUserDetailsService;
//import ru.netology.daohiber.security.filter.TokenAuthenticationFilter;
//
//@Configuration
//@AllArgsConstructor
//public class CloudSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private final PersonsUserDetailsService userDetailsService;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService);
//    }
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http
//                .cors().and()
//                .csrf().disable()
//                .httpBasic().disable()
//                .logout().disable()
//                .addFilterBefore(tokenAuthenticationFilter(), LogoutFilter.class)
//                .authorizeRequests().antMatchers("/login").permitAll()
//                .and()
//                .authorizeRequests().antMatchers("/logout").permitAll()
//                .and()
//                .authorizeRequests().anyRequest().authenticated();
//    }
//
//    @Bean
//    public TokenAuthenticationFilter tokenAuthenticationFilter() {
//        return new TokenAuthenticationFilter(userDetailsService);
//    }
//
//
//
//
//
//}