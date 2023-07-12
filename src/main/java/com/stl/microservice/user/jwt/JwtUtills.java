package com.stl.microservice.user.jwt;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.stl.microservice.user.model.Role;
import com.stl.microservice.user.model.User;
import com.stl.microservice.user.repo.RoleRepo;
import com.stl.microservice.user.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
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
	private static final long TOKEN_VALIDITY = 72 * 60 * 60;
	@Value("${jwt.secret}")
	private String jwtSecret;

	@Autowired
	UserRepo USER_REPO;
	@Autowired
	RoleRepo ROLE_REPO;

	public String generateJwtToken(UserDetails userDetails) {
		User USER= USER_REPO.findByUniqueId(userDetails.getUsername());
		Role ROLE=ROLE_REPO.findById(USER.getROLE_ID()).get();
		Map<String, Object> claims = new HashMap<>();
		claims.put("role_id",USER.getROLE_ID());
		claims.put("role",ROLE.getROLE_NAME());
		claims.put("user_id",USER.getUSER_ID());
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
