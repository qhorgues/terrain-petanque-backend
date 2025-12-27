package com.polytech.terrainpetanque;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.polytech.terrainpetanque.dto.output.UserOutputDTO;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

/**
 * This class can generate a JSON Web Token.
 */
@Component
public class JWTGenerator {

    /**
     * This is the key to sign the JWT.
     */
    private final Key key;



    /**
     * This is the duration of the JWT in millisecond.
     */
    private final long duration;



    /**
     * The constructor.
     *
     * @param key The private key of the JWT.
     * @param duration The duration of the JWT in millisecond.
     */
    public JWTGenerator(@Value("${jwt.secret}") String secret, @Value("${jwt.duration}") long duration) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.duration = duration;
    }



    /**
     * This method generate the JSON Web Token.
     *
     * @param user The user's informations.
     * @return Return the token.
     */
    public String generateToken(UserOutputDTO user) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + duration);

        Map<String, Object> claims = new HashMap<>();
        claims.put("id", user.id());
        claims.put("name", user.name());
        claims.put("surname", user.surname());
        claims.put("mail", user.mail());
        claims.put("username", user.username());

        return Jwts.builder()
                .subject(user.username())
                .claims(claims)
                .issuedAt(now)
                .expiration(expiry)
                .signWith(key)
                .compact();
    }

}
