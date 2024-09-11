package br.org.unisenaipr.comercial.User.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.unisenaipr.comercial.User.entity.User;
import br.org.unisenaipr.comercial.User.service.UserService;
import br.org.unisenaipr.comercial.authenticator.JwtTokenProvider;
import br.org.unisenaipr.comercial.requestDto.LoginRequest;


@RestController
@RequestMapping("/users")
public class UserController {

	 	@Autowired
	    private UserService userService;

	    @Autowired
	    private AuthenticationManager authenticationManager;

	    @Autowired
	    private JwtTokenProvider tokenProvider;

	    @PostMapping("/register")
	    public String registerUser(@RequestBody User user) {
	        userService.saveUser(user);
	        return "User registered successfully";
	    }

	    @PostMapping("/login")
	    public Map<String, String> authenticateUser(@RequestBody LoginRequest loginRequest) {
	        Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                        loginRequest.getUsername(),
	                        loginRequest.getPassword()
	                )
	        );

	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        String jwt = tokenProvider.generateToken(authentication);
	        Map<String, String> response = new HashMap<>();
	        response.put("token", jwt);
	        return response;
	    }
}