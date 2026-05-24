package com.example.usuariosvotaciones.controller;


import com.example.usuariosvotaciones.dto.Auth.LoginRequest;
import com.example.usuariosvotaciones.response.AuthResponse;
import com.example.usuariosvotaciones.service.Auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.function.ThrowingSupplier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @GetMapping("/health")
    public ResponseEntity<String> webAlive() {
        return ResponseEntity.ok("Service is up and running");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RequestBody LoginRequest request) {

        return handleRequestProcess(() -> {
            return  authService.login(request);
        });
    }

    private ResponseEntity<AuthResponse> handleRequestProcess(ThrowingSupplier<AuthResponse> supplier) {
        try {
            return ResponseEntity.ok(supplier.get());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(AuthResponse.builder().message("Internal Server Error").build());
        }
    }
}