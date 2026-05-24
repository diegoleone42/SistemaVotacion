package com.example.usuariosvotaciones.service.Auth;

import com.example.usuariosvotaciones.dto.Auth.LoginRequest;
import com.example.usuariosvotaciones.model.Users;
import com.example.usuariosvotaciones.repository.UsersRepository;
import com.example.usuariosvotaciones.response.AuthResponse;
import com.example.usuariosvotaciones.service.Jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsersRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;


    public AuthResponse login(LoginRequest request) {
        Users user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new BadCredentialsException("Bad credentials"));

        if (user.getAccountLocked()) {
            throw new LockedException("locked account.Change password.");
        }

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );
        } catch (BadCredentialsException e) {
            userService.increaseFailedAttempts(user);
            throw new BadCredentialsException("Bad credentials");
        }

        userService.resetFailedAttempts(user.getEmail());
        String token = jwtService.getToken(user);
        return AuthResponse.builder().token(token).message("Access Allowed").build();
    }

}
