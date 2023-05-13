package com.feign_api.utils;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.UUID;

/**
 * jwt权限认证
 */
public class Jwt {
    /**
     * 构建
     */
    public static String builder(String account){
        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder
                // 1.header 头
                .setHeaderParam("typ", "JWT") //类型jwt
                .setHeaderParam("alg", "HS256") //算法HS256
                // 2.payload 账号 之类的东西
                .claim("account", account)
                //主题
                .setSubject("随便叫个名字")
                //过期时间
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                //设置id
                .setId(UUID.randomUUID().toString())
                //3.signature 签名 解密时需要
                .signWith(SignatureAlgorithm.HS256, "my-books")
                //拼接
                .compact();
        return jwtToken;
    }

    /**
     * 解析是否成功
     */
    public static boolean parse(String token){
        JwtParser jwtParser = Jwts.parser();
        try {
            //解析失败会抛异常 没抛就是成功
            Jws<Claims> claimsJws = jwtParser.setSigningKey("my-books").parseClaimsJws(token);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static String parseToAccount(String token){
        JwtParser jwtParser = Jwts.parser();
        try {
            Jws<Claims> claimsJws = jwtParser.setSigningKey("my-books").parseClaimsJws(token);
            return claimsJws.getBody().get("account").toString();
        } catch (Exception e) {
            return null;
        }
    }
}
