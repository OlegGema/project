package ua.com.owu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import ua.com.owu.entity.Authority;
import ua.com.owu.entity.User;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Configuration
@EnableWebSecurity
@ComponentScan("ua.com.owu.*")
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    UserDetailsService userDetailsService;




    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService);

        return provider;
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("user1").password("123").roles("USER");
//        auth.inMemoryAuthentication().withUser("admin1").password("1111").roles("USER,ADMINISTRATOR");
//        auth.userDetailsService(userDetailsService);
//        auth.authenticationProvider(authenticationProvider());
//    }

    private InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> inMemoryConfigure() {
        return new InMemoryUserDetailsManagerConfigurer();
    }

    @Autowired
    private void globalConfigure(AuthenticationManagerBuilder managerBuilder, AuthenticationProvider provider) throws Exception {
        inMemoryConfigure().withUser("aa").password("123").roles("ADMINISTRATOR").and().configure(managerBuilder);
//        inMemoryConfigure().withUser("user").password("123").roles("USER").and().configure(managerBuilder);
        managerBuilder.authenticationProvider(provider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/","/home").permitAll()
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMINISTRATOR')")
                .antMatchers("/userPage/**").access("hasAnyRole('ROLE_USER','ROLE_ADMINISTRATOR')")
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/userPage")
//                .defaultSuccessUrl("/admin")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .logout().logoutUrl("/logout")
                .logoutSuccessUrl("/logoutPage")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).and()
                .csrf().and().exceptionHandling().accessDeniedPage("/403");
            }

}
