package pe.joedayz.jpademo.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Collections;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

public class AuthenticationService {

  static final long EXPIRATIONTIME = 864_000_00; //1 dia
  static final String SIGNINGKEY = "SecretKey";
  static final String PREFIX = "Bearer";

  public static void addToken(HttpServletResponse response, String username){
    String token = Jwts.builder().setSubject(username)
        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
        .signWith(SignatureAlgorithm.HS512, SIGNINGKEY).compact();
    response.addHeader("Authorization", PREFIX + " "+ token);
    response.addHeader("Access-Control-Expose-Headers", "Authorization");
  }

  //Get token desde el authorization header
  public static Authentication getAuthentication(HttpServletRequest request){
    String token = request.getHeader("Authorization");
    if(token!=null){
      String user = Jwts.parser()
          .setSigningKey(SIGNINGKEY)
          .parseClaimsJws(token.replace(PREFIX, "")).getBody().getSubject();
      if(user!=null)
        return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
    }
    return null;
  }

}
