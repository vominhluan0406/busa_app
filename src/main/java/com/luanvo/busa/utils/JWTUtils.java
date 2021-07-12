package com.luanvo.busa.utils;

import com.luanvo.busa.io.values.UserJWT;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtils {

    @Value("${luanvo.secret_key}")
    private String JWT_SECRET;

    private final long JWT_EXPIRATION = 3600000L;

    public String generateToken(UserJWT userJWT) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + JWT_EXPIRATION);
        return Jwts.builder().setSubject(userJWT.getUsername()).setIssuedAt(now)
                .setExpiration(expiry).signWith(SignatureAlgorithm.HS512, JWT_SECRET).compact();
    }

    public String getUserNameFromJWT(String token) {
        Claims claims = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
