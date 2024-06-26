package com.g_parking.app.security.config;

//import com.g_parking.app.security.jwt.JwtAuthenticationEntryPoint;
import com.g_parking.app.security.jwt.JwtAuthenticationFilter;
import com.g_parking.app.security.jwt.JwtProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//  private final JwtAuthenticationEntryPoint authenticationEntryPoint;
  private final JwtProvider jwtProvider;
  private final UserDetailsService userDetailsService;

  public SecurityConfig(/*JwtAuthenticationEntryPoint authenticationEntryPoint,*/ JwtProvider jwtProvider, UserDetailsService userDetailsService) {
//    this.authenticationEntryPoint = authenticationEntryPoint;
    this.jwtProvider = jwtProvider;
    this.userDetailsService = userDetailsService;
  }

  @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      http
        .csrf(AbstractHttpConfigurer::disable)
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//        .exceptionHandling(
//          exception -> exception.authenticationEntryPoint(authenticationEntryPoint)
//        )
        .authorizeHttpRequests(
          auth -> auth
            .requestMatchers(HttpMethod.POST, "/signup").permitAll()
            .requestMatchers(HttpMethod.POST, "/login").permitAll()
            .requestMatchers(HttpMethod.GET, "/parking/all").permitAll()
            .anyRequest().authenticated()
        )
        .httpBasic(Customizer.withDefaults())
        .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
      return http.build();
    }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
  }

  @Bean
  public JwtAuthenticationFilter jwtAuthenticationFilter(){
    return new JwtAuthenticationFilter(userDetailsService, jwtProvider);
  }
}
