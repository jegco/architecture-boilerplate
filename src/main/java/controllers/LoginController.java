package controllers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class LoginController {

    @RequestMapping("/login")
    public String login() {
        return JWT.create()
                .withClaim("username", "qwerty")
                .withClaim("password", "qwerty")
                .withExpiresAt(new Date(System.currentTimeMillis() + 20000))
                .sign(Algorithm.HMAC256("superSecretKey"));
    }
}
