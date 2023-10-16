package com.abhi.studentapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.abhi.studentapp.auth.ApplicationUserService;

import static com.abhi.studentapp.security.ApplicationUserRole.*;
import static com.abhi.studentapp.security.ApplicationUserPermission.*;




@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig {
	
    private final PasswordEncoder passwordEncoder;
    private final ApplicationUserService applicationUserService;
    

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder,
                                     ApplicationUserService applicationUserService) {
        this.passwordEncoder = passwordEncoder;
        this.applicationUserService = applicationUserService;
    }	
	
	
	
	
	
	
	
	@Bean
	public UserDetailsService userDetailsService() throws Exception {
       UserDetails annaSmithUser = User.builder()
               .username("user")
               .password(passwordEncoder().encode("password"))
//                .roles(STUDENT.name()) // ROLE_STUDENT
               .authorities(STUDENT.getGrantedAuthorities())
               .build();

       UserDetails lindaUser = User.builder()
               .username("admin")
               .password(passwordEncoder().encode("password"))
//                .roles(ADMIN.name()) // ROLE_ADMIN
               .authorities(ADMIN.getGrantedAuthorities())
               .build();

       UserDetails tomUser = User.builder()
               .username("admintrainee")
               .password(passwordEncoder().encode("password"))
//                .roles(ADMINTRAINEE.name()) // ROLE_ADMINTRAINEE
               .authorities(ADMINTRAINEE.getGrantedAuthorities())
               .build();

       return new InMemoryUserDetailsManager(
               annaSmithUser,
               lindaUser,
               tomUser
       );
		
	}

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
	@Bean
	public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
//                .securityMatcher("/api/**")
                .authorizeHttpRequests(authorize -> authorize
//                		.requestMatchers("/api/**").hasRole(STUDENT.name())
//                        .requestMatchers(HttpMethod.DELETE, "/management/api/**").hasAuthority(COURSE_WRITE.getPermission())
//                        .requestMatchers(HttpMethod.POST, "/management/api/**").hasAuthority(COURSE_WRITE.getPermission())
//                        .requestMatchers(HttpMethod.PUT, "/management/api/**").hasAuthority(COURSE_WRITE.getPermission())
//                        .requestMatchers("/management/api/**").hasAnyRole(ADMIN.name(), ADMINTRAINEE.name())
                        .anyRequest()
                        .authenticated()                                
                         )
                 .formLogin()
                 .and()
                .httpBasic();
		return http.build();
	}
	
	
// 	@Bean
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(daoAuthenticationProvider());
//    }
    
    
//     @Bean
//     public AuthenticationManager authManager(HttpSecurity http) throws Exception {
//         AuthenticationManagerBuilder authenticationManagerBuilder = 
//             http.getSharedObject(AuthenticationManagerBuilder.class);
//         authenticationManagerBuilder.authenticationProvider(daoAuthenticationProvider());
//         return authenticationManagerBuilder.build();
//     }

//     @Bean
//     public DaoAuthenticationProvider daoAuthenticationProvider() {
//         DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//         provider.setPasswordEncoder(passwordEncoder);
//         provider.setUserDetailsService(applicationUserService);
//         return provider;
//     }

}


