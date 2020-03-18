package com.exa.vuespringboot.utils;

import java.util.Date;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtil {
	
	private static final Long TIMEOUT_MILLIS = (long) (12 * 60 * 60 * 1000); 
	private static final String JWT_SECERT = "javawolf";
	
    /**
     * 签发JWT
     * @param id
     * @param subject 可以是JSON数据 尽可能少
     * @param ttlMillis
     * @return  String
     *
     */
    public static String createJWT(String id) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        SecretKey secretKey = generalKey();
        JwtBuilder builder = Jwts.builder()
                .setId(id)
                .setSubject("")   // 主题
                .setIssuer("wolf")     // 签发者
                .setIssuedAt(now)      // 签发时间
                .setExpiration(new Date(nowMillis+TIMEOUT_MILLIS)) //过期时间
                .signWith(signatureAlgorithm, secretKey); // 签名算法以及密匙
        return builder.compact();
    }
    /**
     * 验证JWT
     * @param jwtStr
     * @return
     */
    public static boolean validateJWT(String jwtStr) {
        try {
            parseJWT(jwtStr);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public static SecretKey generalKey() {
        byte[] encodedKey = null;
		try {
			encodedKey = Base64.decode(JWT_SECERT);
		} catch (Base64DecodingException e) {
			e.printStackTrace();
		}
		SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }
    
    /**
     * 
     * 解析JWT字符串
     * @param jwt
     * @return
     * @throws Exception
     */
    public static Claims parseJWT(String jwt) throws Exception {
        SecretKey secretKey = generalKey();
        return Jwts.parser()
            .setSigningKey(secretKey)
            .parseClaimsJws(jwt)
            .getBody();
    }
    
}