package com.sparta.msa_exam.auth;


import com.sparta.msa_exam.auth.dto.AuthResponse;
import com.sparta.msa_exam.auth.dto.SignRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @Value("${server.port}")
    private String serverPort;

    private <T>ResponseEntity<T> responseEntity(T body, HttpStatus status) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Server-Port", serverPort);
        return new ResponseEntity<>(body, headers, status);
    }

    @PostMapping("/signIn")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody SignRequest signRequest){
        String token = authService.signIn(signRequest.getUserId(), signRequest.getPassword());
        return responseEntity(new AuthResponse(token), HttpStatus.OK);
    }

    @PostMapping("/signUp")
    public ResponseEntity<?> signUp(@RequestBody SignRequest signInRequest) {
        User createdUser = authService.signUp(signInRequest);
        return responseEntity(createdUser, HttpStatus.OK);
    }

}




