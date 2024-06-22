package ru.turnikman.hh.config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ru.turnikman.hh.model.UserAuthority;

@Slf4j
@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration {
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(expressionInterceptUrlRegistry ->
//                        expressionInterceptUrlRegistry
//                                .anyRequest().permitAll())

//                                .requestMatchers("/","/login","/api/user/**").permitAll()
//                                .requestMatchers(
//                                        "/api/rezume/**",
//                                        "/api/obrazovanie/**",
//                                        "/api/opit_raboti*/**",
//                                        "/api/soiskatel/**"
//                                ).hasAnyAuthority(UserAuthority.SOISKATEL.getAuthority())
//                                .requestMatchers(
//                                        "/api/organizaciya/**",
//                                        "/api/vakanciya/**"
//                                ).hasAnyAuthority(UserAuthority.RABOTODATEL.getAuthority())
//                                .requestMatchers(HttpMethod.GET).permitAll()
//                                .anyRequest().hasAuthority(UserAuthority.ADMIN.getAuthority()))

//                                .requestMatchers("/","/login","/api/user/**").permitAll()
//                                .requestMatchers(HttpMethod.GET, "/items").permitAll())

//                .formLogin(Customizer.withDefaults())
//                .csrf(AbstractHttpConfigurer::disable);
//
//        return http.build();
//    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(expressionInterceptUrlRegistry ->
                        expressionInterceptUrlRegistry
                                .anyRequest().permitAll())
                .formLogin(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
