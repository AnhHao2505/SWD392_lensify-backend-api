package swd_sentify.back_end.Component;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import swd_sentify.back_end.Service.JwtService;

@Component
public class JwtAuthenticationFilter {
    private final HandlerExceptionResolver exceptionResolver;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    public JwtAuthenticationFilter(@Qualifier("handlerExceptionResolver")HandlerExceptionResolver exceptionResolver, JwtService jwtService, UserDetailsService userDetailsService) {
        this.exceptionResolver = exceptionResolver;
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }
}
