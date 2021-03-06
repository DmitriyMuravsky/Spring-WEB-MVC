package dmuravsky.config;

import dmuravsky.security.AuthProviderImpl;
import dmuravsky.security.AuthenticationHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@ComponentScan("dmuravsky.security")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthProviderImpl authProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/auth/*").anonymous()
                .antMatchers( "/user/*").hasAuthority("user")
                .antMatchers("/admin/*").hasAuthority("admin")
                .and().csrf().disable()
                .formLogin()
                .loginPage("/auth/signIn")
                .loginProcessingUrl("/auth/signIn/process").successHandler(authenticationHandler())
                .usernameParameter("login")
                .and().logout().logoutUrl("/logout").invalidateHttpSession(true).logoutSuccessUrl("/");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
    }

    @Bean
    public AuthenticationSuccessHandler authenticationHandler(){
        return new AuthenticationHandler();
    }
}
