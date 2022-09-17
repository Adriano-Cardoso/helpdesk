package com.adriano.helpedesk.controller;

import com.adriano.helpedesk.domain.dto.request.LoginRequest;
import com.adriano.helpedesk.domain.dto.response.LoginResponse;
import com.adriano.helpedesk.service.LoginService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Login Endpoints", description = "HelpDesk", tags = {"Login Endpoint"})
@RequestMapping("/auth")
@AllArgsConstructor
@RestController
public class LoginController {

    private LoginService loginService;

    @PostMapping
    public ResponseEntity<LoginResponse> auth(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(loginService.auth(loginRequest));
    }
}
