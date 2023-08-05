package com.task.project.auth;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.task.project.Config.JwtService;
import com.task.project.Model.Role;
import com.task.project.Model.Token;
import com.task.project.Model.TokenType;
import com.task.project.Model.User;
import com.task.project.Repository.TokenRepository;
import com.task.project.Repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AutheticationService {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final TokenRepository tokenRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private final JwtService jwtService;

    @Autowired
    private final AuthenticationManager authenticationManager;

    /**
     * The register function takes a RegisterRequest object, creates a new User
     * object with the provided
     * information, saves it to the userRepository, generates a JWT token for the
     * user, saves the token
     * to the user, and returns an AuthenticationResponse object with the token.
     * 
     * @param request The "request" parameter is an object of type
     *                "RegisterRequest". It contains the
     *                information needed to register a new user, such as the user's
     *                name, email, password, address, and
     *                bio.
     * @return The method is returning an instance of the AuthenticationResponse
     *         class.
     */
    public AuthenticationResponse register(ResgisterRequest request) {
        var user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .address(request.getAddress())
                .bio(request.getBio())
                .followersId(new ArrayList<>())
                .role(Role.USER)

                .build();
        var savedUser = userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        saveUserToken(savedUser, jwtToken);
        return AuthenticationResponse.builder().token(jwtToken).build();

    }

    private void revokeAllUSerToken(User user) {
        var validUserTokens = tokenRepository.findAllValidTokensByUser(user.getId());
        if (validUserTokens.isEmpty()) {
            return;
        }
        validUserTokens.forEach(t -> {
            t.setExpired(true);
            t.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    /**
     * The `authenticate` function takes an `AuthenticationRequest` object,
     * authenticates the user,
     * generates a JWT token, revokes all user tokens, saves the new token, and
     * returns an
     * `AuthenticationResponse` object containing the token.
     * 
     * @param request An object of type AuthenticationRequest, which contains the
     *                email and password
     *                entered by the user for authentication.
     * @return The method is returning an instance of the AuthenticationResponse
     *         class.
     */
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        revokeAllUSerToken(user);
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

}
