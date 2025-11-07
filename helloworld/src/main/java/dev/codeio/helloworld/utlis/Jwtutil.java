package dev.codeio.helloworld.utlis;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class Jwtutil {
    private final String SECRET="Code io - Tamil";
    private final long EXPIRATION=1000*30;
    private final Key secretkey= Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    public String generateToken(String email){
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(secretkey, SignatureAlgorithm.ES256)
                .compact();
    }

    public boolean extractEmail(String token){
        return Jwts.parserBuilder()
                .setSigningKey(secretkey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateJwtToken(String token){
        try{
            extractEmail(token);
            return true;

        } catch (JwtException exception){

            return false;
        }
    }
}
