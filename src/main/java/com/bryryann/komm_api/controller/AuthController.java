package com.bryryann.komm_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity login() {
        // TODO: implement the /login route.
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/register")
    public ResponseEntity register() {
        // TODO: implement the /register route.
        return ResponseEntity.notFound().build();
    }

}
