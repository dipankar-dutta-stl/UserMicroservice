package com.stl.microservice.user.jwt;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtills implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final long TOKEN_VALIDITY = 48 * 60 * 60;
	@Value("${jwt.secret}")
	private String jwtSecret;

	public String generateJwtToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return Jwts.builder().setClaims(claims).setSubject(userDetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	}

	public Boolean validateJwtToken(String token, UserDetails userDetails) throws Exception{
		String username = getUniqueIdFromToken(token);
		Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
		Boolean isTokenExpired = claims.getExpiration().before(new Date());
		return (username.equals(userDetails.getUsername()) && !isTokenExpired);
	}

	public String getUniqueIdFromToken(String token) {
		final Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
		return claims.getSubject();
	}

	public String expireToken(String token){
		final Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
		claims.setExpiration(new Date(System.currentTimeMillis() +0* 1000));
		String EXP_TOKEN=Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
		return EXP_TOKEN;
	}

}
