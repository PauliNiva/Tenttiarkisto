package tenttiarkisto.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import tenttiarkisto.auth.JpaAuthenticationProvider;

@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, proxyTargetClass = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
                
        http.authorizeRequests()
                .antMatchers("/kurssit/*").permitAll()
                .antMatchers("/kurssit").permitAll()
                .antMatchers("/tentit").permitAll()
                .antMatchers("/tentit/*").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/assets/*/*").permitAll()
                .antMatchers("/assets/*/*/*").permitAll()
                .antMatchers("/assets/*/*/*/*").permitAll()
                .antMatchers("/kirjaudu").permitAll()
                .antMatchers("/tervetuloa").permitAll()
                .antMatchers("/kommentit/*").permitAll()
                
                .antMatchers("/kurssis").permitAll()
                .antMatchers("/kurssis/*").permitAll()
                .antMatchers("/tenttis").permitAll()
                .antMatchers("/tenttis/*").permitAll()
                
                .anyRequest().authenticated();
        
        
        http.formLogin()
                .loginPage("/kirjaudu")
                .loginProcessingUrl("/tervetuloa")
                .defaultSuccessUrl("/kurssit")
                .usernameParameter("kayttaja")
                .passwordParameter("salasana")
                .permitAll();

        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/kirjaudu")
                .permitAll()
                .invalidateHttpSession(true);

    }

    @Configuration
    protected static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {

        @Autowired
        private JpaAuthenticationProvider jpaAuthenticationProvider;

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            auth.authenticationProvider(jpaAuthenticationProvider);
        }
    }
}
