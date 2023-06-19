package com.adriano.helpedesk.controller;

import com.adriano.helpedesk.domain.dto.request.ClienteRequest;
import com.adriano.helpedesk.domain.dto.request.ClienteUpdateRequest;
import com.adriano.helpedesk.domain.dto.response.ClienteResponse;
import com.adriano.helpedesk.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
@Tag(name = "cliente Endpoints", description = "HelpDesk")
public class ClienteController {

    private ClienteService clienteService;

    @Operation(summary = "Busca cliente por id")
    @GetMapping("/{clienteId}")
    public ResponseEntity<ClienteResponse> findById(@PathVariable("clienteId") Long clienteId) {
        return ResponseEntity.status(HttpStatus.OK).body(this.clienteService.findById(clienteId));
    }

    @Operation(summary = "Busca todos os clientes")
    @GetMapping
    public ResponseEntity<List<ClienteResponse>> findAllTecnico() {
        return ResponseEntity.status(HttpStatus.OK).body(this.clienteService.findAllCliente());
    }

    @Operation(summary = "Cria um novo cliente")
    @PostMapping
    public ResponseEntity<ClienteResponse> createTecnico(@RequestBody ClienteRequest clienteRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.clienteService.createCliente(clienteRequest));
    }

    @Operation(summary = "Atualiza o cliente por id")
    @PatchMapping("/{clienteId}")
    public ResponseEntity<ClienteResponse> update(@PathVariable("clienteId") Long clienteId, @RequestBody ClienteUpdateRequest clienteRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(this.clienteService.update(clienteId, clienteRequest));
    }

    @Operation(summary = "Exclusão de cliente por id")
    @DeleteMapping("/{clienteId}")
    public ResponseEntity<ClienteResponse> delete(@PathVariable("clienteId") Long clienteId) {
        this.clienteService.delete(clienteId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
