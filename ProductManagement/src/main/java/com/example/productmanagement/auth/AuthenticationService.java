package com.example.productmanagement.auth;


import com.example.productmanagement.config.JwtService;
import com.example.productmanagement.user.User;
import com.example.productmanagement.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final UserRepository repository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;


  public ResponseEntity<?> register(UserRequest request) {

    if(repository.findByEmail(request.getEmail()).isPresent()){
      return new ResponseEntity<>("User already registered",HttpStatus.BAD_REQUEST);
    }
    var user = User.builder()
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .build();
    repository.save(user);
    var jwtToken = jwtService.generateToken(user);
    return new ResponseEntity<>(AuthenticationResponse.builder()
            .id(user.getId())
            .message("User successfully registered.")
            .token(jwtToken)
            .build(),HttpStatus.CREATED);
  }



  public AuthenticationResponse authenticate(UserRequest request) {
    authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    request.getEmail(),
                    request.getPassword()
            )
    );
    var user = repository.findByEmail(request.getEmail())
            .orElseThrow();
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
            .id(user.getId())
            .token(jwtToken)
            .build();
  }
}
