package com.bryryann.komm_api.controller;

import com.bryryann.komm_api.dto.LoginRequestDTO;
import com.bryryann.komm_api.dto.LoginResponseDTO;
import com.bryryann.komm_api.dto.RegisterRequestDTO;
import com.bryryann.komm_api.model.AppUser;
import com.bryryann.komm_api.repository.AppUserRepository;
import com.bryryann.komm_api.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final AppUserRepository appUserRepository;
    private final TokenService tokenService;

    @Autowired
    public AuthController(
            AuthenticationManager authenticationManager,
            AppUserRepository appUserRepository,
            TokenService tokenService
    ) {
        this.authenticationManager = authenticationManager;
        this.appUserRepository = appUserRepository;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO dto) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(dto.username(), dto.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((AppUser) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO dto) {
        if (this.appUserRepository.findByUsername(dto.username()) != null)
            return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(dto.password());
        AppUser user = new AppUser(dto.username(), encryptedPassword, dto.role());
        this.appUserRepository.save(user);

        return ResponseEntity.ok().build();
    }

}
