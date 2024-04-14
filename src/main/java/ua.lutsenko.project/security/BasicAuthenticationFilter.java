package ua.lutsenko.project.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import ua.lutsenko.project.exception.authorization.BadCredentialsException;

import java.io.IOException;
import java.util.Base64;

@Component
@RequiredArgsConstructor
public class BasicAuthenticationFilter extends HttpFilter {
    private static final String BASIC_AUTH_SCHEMA = "basic";
    private final AuthenticationManager authenticationManager;
    @Override
    protected void doFilter(HttpServletRequest request,
                            HttpServletResponse response,
                            FilterChain chain) throws IOException, ServletException {

        String url = request.getRequestURI();

        if(ProtectedEndpoints.getEndpoints().contains(url)){
            super.doFilter(request, response, chain);
            return;
        }

        Authentication authentication = parseHeaders(request);
        if(!authenticationManager.isAuthenticated(authentication)){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        SecurityContextHolder.getSecurityContext().setAuthentication(authentication);

        super.doFilter(request, response, chain);
    }

    private Authentication parseHeaders(HttpServletRequest request) {
        String header = request.getHeader("Authorization");

        if(header == null){
            throw new BadCredentialsException("Header have to contain header");
        }

        header = header.trim();
        if(!StringUtils.startsWithIgnoreCase(header, BASIC_AUTH_SCHEMA)){
            throw new BadCredentialsException("Header gotta contains BASIC authorization header");
        }

        if(header.equalsIgnoreCase(BASIC_AUTH_SCHEMA)){
            throw new BadCredentialsException("Header have to contain header");
        }

        String token = header.substring(6);
        byte[] decode = Base64.getDecoder().decode(token);

        String loginPass = new String(decode);

        int delim = loginPass.indexOf(":");
        if(delim == -1){
            throw new BadCredentialsException("Incorrect credentials");
        }

        String login = loginPass.substring(0, delim);
        String password = loginPass.substring(delim + 1);

        return new LoginPasswordAuthenticationToken(login, password);
    }


}
