package com.adriano.helpedesk.controller;

import com.adriano.helpedesk.domain.dto.request.LoginRequest;
import com.adriano.helpedesk.domain.dto.response.LoginResponse;
import com.adriano.helpedesk.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
@Tag(name = "Login Endpoints", description = "HelpDesk")
public class LoginController {

    private LoginService loginService;

    @Operation(summary = "Autenticação do usuário")
    @PostMapping
    public ResponseEntity<LoginResponse> auth(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(loginService.auth(loginRequest));
    }
}
