package com.eshopping.eshopping_backend.util;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {

    private static final String SECRET_KEY = "maCleSuperSecreteTrèsLonguePourJWT1234567890!"; // 32+ chars

    private static final long EXPIRATION_TIME = 86400000; // 1 jour

    private static final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    public static String generateToken(String email) {
        JwtBuilder builder = Jwts.builder();
        builder.setSubject(email);
        builder.setIssuedAt(new Date(System.currentTimeMillis()));
        builder.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME));
        builder.signWith(key);
        return builder  // plus besoin de passer SignatureAlgorithm
                .compact();
    }

    public static String extractEmail(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public static boolean validateToken(String token) {
        try {
            Jwts.builder()
                    .setIssuer(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}

