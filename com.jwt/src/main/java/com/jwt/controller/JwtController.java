package com.jwt.controller;

import com.jwt.helper.JwtUtil;
import com.jwt.model.JwtRequest;
import com.jwt.model.JwtResponse;
import com.jwt.services.CustomerUserDetailSrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private CustomerUserDetailSrvice customerUserDetailSrvice;
    @Autowired
    private JwtUtil jwtUtil;
@RequestMapping(value="/token",method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest)throws Exception{
    try{
        this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),jwtRequest.getPassword()));
        System.out.println("kjsnuw");
        System.out.print("Transition is like a nimvnern governmengt");
    }
    catch(Exception e){

    throw new Exception("Bad Credential");
    }
    //since password is correct so we have to generate token and forgenerating token we have to get the user detail
    UserDetails userDetails= this.customerUserDetailSrvice.loadUserByUsername(jwtRequest.getUsername());
    String token=this.jwtUtil.generateToken(userDetails);
    System.out.println("JWT "+token);
    return  ResponseEntity.ok(new JwtResponse(token));
    }
}
