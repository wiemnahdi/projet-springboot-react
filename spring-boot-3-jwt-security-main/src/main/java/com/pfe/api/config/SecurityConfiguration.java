package com.pfe.api.config;

import com.pfe.api.entities.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {

    private static final String[] WHITE_LIST_URL = {"/api/v1/auth/**",
            "/v2/api-docs",
            "/v3/api-docs",
            "/v3/api-docs/**",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui/**",
            "/webjars/**",
            "/swagger-ui.html"};
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req ->
                        req.requestMatchers(WHITE_LIST_URL)
                                .permitAll()
                                .requestMatchers("/api/v1/departementchef/**").hasRole("ADMIN")
                                .requestMatchers(GET,"/api/v1/departementchef/**").hasRole("ADMIN")
                                .requestMatchers(POST,"/api/v1/departementchef/**").hasRole("ADMIN")
                                .requestMatchers(PUT,"/api/v1/departementchef/**").hasRole("ADMIN")
                                .requestMatchers(DELETE,"/api/v1/departementchef/**").hasRole("ADMIN")
                                .requestMatchers("/api/v1/employe/**").hasRole("TEAM_LEADER")
                                .requestMatchers(GET,"/api/v1/employe/**").hasRole("TEAM_LEADER")
                                .requestMatchers(POST,"/api/v1/employe/**").hasRole("TEAM_LEADER")
                                .requestMatchers(PUT,"/api/v1/employe/**").hasRole("TEAM_LEADER")
                                .requestMatchers(DELETE,"/api/v1/employe/**").hasRole("TEAM_LEADER")
                                .requestMatchers("/api/v1/departement/**").hasRole("ADMIN")
                                .requestMatchers(GET,"/api/v1/departement/**").hasRole("ADMIN")
                                .requestMatchers(POST,"/api/v1/departement/**").hasRole("ADMIN")
                                .requestMatchers(PUT,"/api/v1/departement/**").hasRole("ADMIN")
                                .requestMatchers(DELETE,"/api/v1/departement/**").hasRole("ADMIN")
                                .requestMatchers("/api/v1/competence/**").hasRole("TEAM_LEADER")
                                .requestMatchers(GET,"/api/v1/competence/**").hasRole("TEAM_LEADER")
                                .requestMatchers(POST,"/api/v1/competence/**").hasRole("TEAM_LEADER")
                                .requestMatchers(PUT,"/api/v1/competence/**").hasRole("TEAM_LEADER")
                                .requestMatchers(DELETE,"/api/v1/competence/**").hasRole("TEAM_LEADER")
                                .requestMatchers("/api/v1/team/**").hasRole("DEPARTEMENT_CHEF")
                                .requestMatchers(GET,"/api/v1/team/**").hasRole("DEPARTEMENT_CHEF")
                                .requestMatchers(POST,"/api/v1/team/**").hasRole("DEPARTEMENT_CHEF")
                                .requestMatchers(PUT,"/api/v1/team/**").hasRole("DEPARTEMENT_CHEF")
                                .requestMatchers(DELETE,"/api/v1/team/**").hasRole("DEPARTEMENT_CHEF")
                                .requestMatchers("/api/v1/teamleader/**").hasRole("DEPARTEMENT_CHEF")
                                .requestMatchers(GET,"/api/v1/teamleader/**").hasRole("DEPARTEMENT_CHEF")
                                .requestMatchers(POST,"/api/v1/teamleader/**").hasRole("DEPARTEMENT_CHEF")
                                .requestMatchers(PUT,"/api/v1/teamleader/**").hasRole("DEPARTEMENT_CHEF")
                                .requestMatchers(DELETE,"/api/v1/teamleader/**").hasRole("DEPARTEMENT_CHEF")
                                .requestMatchers("/api/v1/formation/**").hasRole("TEAM_LEADER")
                                .requestMatchers(GET,"/api/v1/formation/**").hasRole("TEAM_LEADER")
                                .requestMatchers(POST,"/api/v1/formation/**").hasRole("TEAM_LEADER")
                                .requestMatchers(PUT,"/api/v1/formation/**").hasRole("TEAM_LEADER")
                                .requestMatchers(DELETE,"/api/v1/formation/**").hasRole("TEAM_LEADER")
//                                .requestMatchers("/api/v1/management/**").hasAnyRole(Role.ADMIN.name(), Role.MANAGER.name())
//                                .requestMatchers(GET, "/api/v1/management/**").hasAnyAuthority(Permission.ADMIN_READ.name(), Permission.MANAGER_READ.name())
//                                .requestMatchers(POST, "/api/v1/management/**").hasAnyAuthority(Permission.ADMIN_CREATE.name(), Permission.MANAGER_CREATE.name())
//                                .requestMatchers(PUT, "/api/v1/management/**").hasAnyAuthority(Permission.ADMIN_UPDATE.name(), Permission.MANAGER_UPDATE.name())
//                                .requestMatchers(DELETE, "/api/v1/management/**").hasAnyAuthority(Permission.ADMIN_DELETE.name(), Permission.MANAGER_DELETE.name())

                                .anyRequest()
                                .authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .logout(logout ->
                        logout.logoutUrl("/api/v1/auth/logout")
                                .addLogoutHandler(logoutHandler)
                                .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
                )
        ;

        return http.build();
    }
}
