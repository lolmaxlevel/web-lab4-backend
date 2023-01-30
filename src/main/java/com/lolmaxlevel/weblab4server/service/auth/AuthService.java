package com.lolmaxlevel.weblab4server.service.auth;

import com.lolmaxlevel.weblab4server.dto.JwtRequest;
import com.lolmaxlevel.weblab4server.dto.JwtResponse;
import lombok.NonNull;

import javax.security.auth.message.AuthException;

public interface AuthService {
    JwtResponse login(@NonNull JwtRequest request) throws AuthException;

    JwtResponse refreshAccessToken(@NonNull String refreshToken) throws AuthException;
}
