package com.utn.elbuensabor.Config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import com.utn.elbuensabor.Jwt.JwtAuthenticationFilter;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authRequest ->
                authRequest
                        //El uso de AntPathRequestMatcher fue indicado por el profe el 10/11 a las 20:59 por el grupo de Whatsapp
                        //Autenticacion
                        .requestMatchers(new AntPathRequestMatcher("/auth/**")).permitAll()
                        //Consola H2:
                        .requestMatchers(PathRequest.toH2Console()).permitAll()
                        //Autorizacion de acceso a las urls:
                        .requestMatchers(new AntPathRequestMatcher("/api/v1/facturacion/**")).hasAnyAuthority("ADMINISTRADOR", "DELIVERY", "CAJERO", "CLIENTE")
                        .requestMatchers(new AntPathRequestMatcher("/api/v1/pedidos/**")).hasAnyAuthority("ADMINISTRADOR", "COCINERO", "DELIVERY", "CAJERO", "CLIENTE")
                        .requestMatchers(new AntPathRequestMatcher("/api/v1/productos/producto/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/api/v1/productos/rubroProducto/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/api/v1/productos/compraInsumo/**")).hasAnyAuthority("ADMINISTRADOR", "COCINERO")
                        .requestMatchers(new AntPathRequestMatcher("/api/v1/productos/detalleCompra/**")).hasAnyAuthority("ADMINISTRADOR", "COCINERO")
                        .requestMatchers(new AntPathRequestMatcher("/api/v1/productos/receta/**")).hasAnyAuthority("ADMINISTRADOR", "COCINERO")
                        .requestMatchers(new AntPathRequestMatcher("/api/v1/productos/detalleReceta/**")).hasAnyAuthority("ADMINISTRADOR", "COCINERO")
                        .requestMatchers(new AntPathRequestMatcher("/api/v1/productos/insumo/**")).hasAnyAuthority("ADMINISTRADOR", "COCINERO")
                        .requestMatchers(new AntPathRequestMatcher("/api/v1/productos/rubroInsumo/**")).hasAnyAuthority("ADMINISTRADOR", "COCINERO")
                        .requestMatchers(new AntPathRequestMatcher("/api/v1/productos/unidadMedida/**")).hasAnyAuthority("ADMINISTRADOR", "COCINERO")
                        .requestMatchers(new AntPathRequestMatcher("/api/v1/usuarios/**")).hasAnyAuthority("ADMINISTRADOR", "COCINERO", "DELIVERY", "CAJERO", "CLIENTE")

            )
            .cors(withDefaults())
            .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable)) //H2
            .sessionManagement(sessionManager->
                    sessionManager
                            .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authenticationProvider(authProvider)
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
            .build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
