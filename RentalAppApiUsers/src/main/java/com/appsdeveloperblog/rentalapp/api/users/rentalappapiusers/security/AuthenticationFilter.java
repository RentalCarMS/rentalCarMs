package com.appsdeveloperblog.rentalapp.api.users.rentalappapiusers.security;

import com.appsdeveloperblog.rentalapp.api.users.rentalappapiusers.business.abstracts.UserService;
import com.appsdeveloperblog.rentalapp.api.users.rentalappapiusers.business.dtos.UserSearchListDto;
import com.appsdeveloperblog.rentalapp.api.users.rentalappapiusers.models.UserRequest.LoginUserRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private UserService userService;
    private Environment environment;


    public AuthenticationFilter(AuthenticationManager authenticationManager, UserService userService, Environment environment) {
        super.setAuthenticationManager(authenticationManager);
        this.userService = userService;
        this.environment = environment;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        try {
            LoginUserRequest credidentals = new ObjectMapper().readValue(request.getInputStream(),LoginUserRequest.class);

            return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(credidentals.getEmail(),
                    credidentals.getPassword(),new ArrayList<>()));


        }catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
       String userName = ((User)authResult.getPrincipal()).getUsername();
        UserSearchListDto userDetails = this.userService.getUserDetailsByEmail(userName).getData();

        String token = Jwts.builder().setSubject(userDetails.getEmail())
                .setExpiration(new Date(System.currentTimeMillis()+Long.parseLong(this.environment.getProperty("token.expiration"))))
                .signWith(SignatureAlgorithm.HS512, this.environment.getProperty("token.secret"))
                .compact();

        response.addHeader("token", token);
        response.addHeader("userEmail", userDetails.getEmail());


    }
}
