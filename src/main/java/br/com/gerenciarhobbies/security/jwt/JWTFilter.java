package br.com.gerenciarhobbies.security.jwt;

import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static br.com.gerenciarhobbies.util.VerificadorUtil.naoEstaNulo;

public class JWTFilter extends GenericFilterBean {

    private static final String BEARER_TOKEN_PREFIX = "Bearer ";

    private final TokenProvider tokenProvider;

    public JWTFilter(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String token = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);

        if (naoEstaNulo(token) && token.startsWith(BEARER_TOKEN_PREFIX)
                && this.tokenProvider.validarToken(token.substring(BEARER_TOKEN_PREFIX.length()))) {
            Authentication authentication = this.tokenProvider.getAuthentication(token.substring(BEARER_TOKEN_PREFIX.length()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
