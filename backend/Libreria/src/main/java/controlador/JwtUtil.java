package controlador;

import java.util.Date;
import java.security.Key;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {
	
	private static final Key CLAVE = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	private static final long TIEMPOEXPIRACION = 21600000;
	
	public static String generarToken(String nombre){
		Date now = new Date();
		Date horaExp = new Date(now.getTime() + TIEMPOEXPIRACION);
		return Jwts.builder()
	            .setSubject(nombre)
	            .setIssuedAt(now)
	            .setExpiration(horaExp)
	            .signWith(CLAVE)
	            .compact();
	}
	
	
}
