package com.adriano.helpedesk.controller;

import com.adriano.helpedesk.domain.dto.request.ClienteRequest;
import com.adriano.helpedesk.domain.dto.request.ClienteUpdateRequest;
import com.adriano.helpedesk.domain.dto.response.ClienteResponse;
import com.adriano.helpedesk.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "cliente Endpoints", description = "HelpDesk", tags = {"cliente Endpoint"})
@RestController
@AllArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {


    private ClienteService clienteService;

    @ApiOperation(value = "Busca cliente por id")
    @GetMapping("/{clienteId}")
    public ResponseEntity<ClienteResponse> findById(@PathVariable("clienteId") Long clienteId) {
        return ResponseEntity.status(HttpStatus.OK).body(this.clienteService.findById(clienteId));
    }

    @ApiOperation(value = "Busca todos os clientes")
    @GetMapping
    public ResponseEntity<List<ClienteResponse>> findAllTecnico() {
        return ResponseEntity.status(HttpStatus.OK).body(this.clienteService.findAllCliente());
    }

    @ApiOperation(value = "Cria um novo cliente")
    @PostMapping
    public ResponseEntity<ClienteResponse> createTecnico(@RequestBody ClienteRequest clienteRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.clienteService.createCliente(clienteRequest));
    }

    @ApiOperation(value = "Atualiza o cliente por id")
    @PatchMapping("/{clienteId}")
    public ResponseEntity<ClienteResponse> update(@PathVariable("clienteId") Long clienteId, @RequestBody ClienteUpdateRequest clienteRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(this.clienteService.update(clienteId, clienteRequest));
    }

    @ApiOperation(value = "Exclusão de cliente por id")
    @DeleteMapping("/{clienteId}")
    public ResponseEntity<ClienteResponse> delete(@PathVariable("clienteId") Long clienteId) {
        this.clienteService.delete(clienteId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
