package swd_sentify.back_end.Service;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;
import java.util.function.Function;

public interface JwtService {
    String extractEmail(String token);

    <T> T extractClaim(String token, Function<Claims, T> claimsResolver);

    String generateToken(UserDetails userDetails);

    String generateToken(Map<String, Object> extraClaims, UserDetails userDetails);

    String generateTokenWithCustomExpiration(UserDetails userDetails, long expirationMs);

    boolean isTokenValid(String token, UserDetails userDetails);

    long getExpirationTime();
}
