package com.task.project.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AutheticationService autheticationService;

    /**
     * The function is a POST endpoint that registers a user and returns an
     * authentication response.
     * 
     * @param request The `request` parameter is of type `ResgisterRequest` and it
     *                represents the request
     *                body that is sent in the POST request to the "/register"
     *                endpoint.
     * @return The method is returning a ResponseEntity object with a generic type
     *         of
     *         AuthenticationResponse.
     */

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody ResgisterRequest request) {
        return ResponseEntity.ok(autheticationService.register(request));
    }

    /**
     * The `authenticate` function in this Java code is a POST endpoint that takes
     * in an
     * `AuthenticationRequest` object as a request body and returns a
     * `ResponseEntity` containing an
     * `AuthenticationResponse` object.
     * 
     * @param request The request parameter is an object of type
     *                AuthenticationRequest. It is passed in
     *                the request body and contains the necessary information for
     *                authentication, such as username and
     *                password.
     * @return The method is returning a ResponseEntity object with a generic type
     *         of
     *         AuthenticationResponse.
     */
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(autheticationService.authenticate(request));
    }

}
