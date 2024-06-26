package com.g_parking.app.security.jwt;

import com.g_parking.app.security.config.SecurityConstants;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

  private final UserDetailsService userDetailsService;

  private final JwtProvider jwtProvider;

  public JwtAuthenticationFilter(UserDetailsService userDetailsService, JwtProvider jwtProvider) {
    this.userDetailsService = userDetailsService;
    this.jwtProvider = jwtProvider;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
    throws ServletException, IOException {

    String token = resolveToken(request);

    if(StringUtils.hasText(token) && jwtProvider.validateToken(token)){
      String username = jwtProvider.getUsernameFromJWT(token);
      UserDetails userDetails = userDetailsService.loadUserByUsername(username);

      UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
        userDetails, null, userDetails.getAuthorities()
      );

      authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
      SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }
    filterChain.doFilter(request, response);
  }

  private String resolveToken(HttpServletRequest request) {
    String bearerToken = request.getHeader(SecurityConstants.AUTHORIZATION_HEADER);
    if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(SecurityConstants.PREFIX_TOKEN)) {
      return bearerToken.substring(7);
    }
    return null;
  }
}
