package com.barsat.touch_grass.Controller;

import com.barsat.touch_grass.Repository.UserRepo;
import com.barsat.touch_grass.Request.LoginRequest;
import com.barsat.touch_grass.Request.SignUpRequest;
import com.barsat.touch_grass.Response.AuthResposne;
import com.barsat.touch_grass.Security.Service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public/auth")
public class AuthController {


    private final AuthService authService;
    private final UserRepo userRepo;

    public AuthController(AuthService authService, UserRepo userRepo) {
        this.authService = authService;
        this.userRepo = userRepo;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @PostMapping("/register")
    public ResponseEntity<String>  register( @RequestBody SignUpRequest signUpRequest) {

        if(userRepo.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body("Email already exists in the database.");
        }

        if(userRepo.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body("Username already exists in the database.");
        }

        authService.register(signUpRequest);

        return ResponseEntity.ok("You are registered successfully.");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResposne> login(@RequestBody LoginRequest loginRequest) {

        AuthResposne authResposne = new AuthResposne();

        if(userRepo.existsByUsername(loginRequest.getUsername()) & authService.loginVerify(loginRequest).equals("Invalid username or password")) {
            authResposne.setMessage("Invalid username or password");
            return ResponseEntity.badRequest().body(authResposne);
        }
        else{
            authResposne.setMessage("Logged in");
            authResposne.setJwtToken(authService.loginVerify(loginRequest));
            return ResponseEntity.ok(authResposne);
        }


    }



}