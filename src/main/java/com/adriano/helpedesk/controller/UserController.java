package com.adriano.helpedesk.controller;

import com.adriano.helpedesk.domain.dto.request.UserRequest;
import com.adriano.helpedesk.domain.dto.response.UserResponse;
import com.adriano.helpedesk.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Tag(name = "User Endpoints", description = "HelpDesk")
public class UserController {

    private UserService userService;

    @Operation(summary = "Cria um novo usuário")
    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest userRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userRequest));
    }
}
