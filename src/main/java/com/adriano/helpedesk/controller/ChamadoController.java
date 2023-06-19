package com.adriano.helpedesk.controller;

import com.adriano.helpedesk.domain.dto.request.ChamadoRequest;
import com.adriano.helpedesk.domain.dto.request.ChamadoUpdateRequest;
import com.adriano.helpedesk.domain.dto.response.ChamadoResponse;
import com.adriano.helpedesk.exception.BusinessException;
import com.adriano.helpedesk.service.ChamadoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chamados")
@AllArgsConstructor
@Tag(name = "chamados Endpoint", description = "HelpDesk")
public class ChamadoController {

    private ChamadoService chamadoService;

    @PostMapping
    public ResponseEntity<ChamadoResponse> save(@RequestBody ChamadoRequest chamadoRequest) throws BusinessException {
        return ResponseEntity.status(HttpStatus.OK).body(this.chamadoService.save(chamadoRequest));
    }

    @Operation(summary = "Busca chamado por id")
    @GetMapping("/{chamadoId}")
    public ResponseEntity<ChamadoResponse> findById(@PathVariable("chamadoId") Long chamadoId) {
        return ResponseEntity.status(HttpStatus.OK).body(this.chamadoService.findByIdChamado(chamadoId));
    }

    @Operation(summary = "Busca todos os Chamados")
    @GetMapping
    public ResponseEntity<List<ChamadoResponse>> findAllTecnico() {
        return ResponseEntity.status(HttpStatus.OK).body(this.chamadoService.findAllChamados());
    }

    @PatchMapping("/{chamadoId}")
    public ResponseEntity<ChamadoResponse> update(@PathVariable("chamadoId") Long chamadoId, @RequestBody ChamadoUpdateRequest chamadoUpdateRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(this.chamadoService.update(chamadoId, chamadoUpdateRequest));
    }
}
