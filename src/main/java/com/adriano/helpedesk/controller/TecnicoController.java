package com.adriano.helpedesk.controller;

import com.adriano.helpedesk.domain.dto.request.TecnicoRequest;
import com.adriano.helpedesk.domain.dto.response.TecnicoResponse;
import com.adriano.helpedesk.service.TecnicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tecnicos")
@AllArgsConstructor
@Tag(name = "Tecnico Endpoints", description = "HelpDesk")
public class TecnicoController {

    private TecnicoService tecnicoService;

    @Operation(summary = "Busca técnico por ID")
    @GetMapping("/{tecnicoId}")
    public ResponseEntity<TecnicoResponse> findById(@PathVariable("tecnicoId") Long tecnicoId) {
        return ResponseEntity.status(HttpStatus.OK).body(this.tecnicoService.findById(tecnicoId));
    }

    @Operation(summary = "Busca todos os técnicos")
    @GetMapping
    public ResponseEntity<List<TecnicoResponse>> findAllTecnico() {
        return ResponseEntity.status(HttpStatus.OK).body(this.tecnicoService.findAllTecnico());
    }

    @Operation(summary = "Cria um novo técnico")
    @PostMapping
    public ResponseEntity<TecnicoResponse> createTecnico(@RequestBody TecnicoRequest tecnicoRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.tecnicoService.createTecnico(tecnicoRequest));
    }

    @Operation(summary = "Atualiza um técnico por ID")
    @PutMapping("/{tecnicoId}")
    public ResponseEntity<TecnicoResponse> update(@PathVariable("tecnicoId") Long tecnicoId, @RequestBody TecnicoRequest tecnicoRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(this.tecnicoService.update(tecnicoId, tecnicoRequest));
    }

    @Operation(summary = "Exclui um técnico por ID")
    @DeleteMapping("/{tecnicoId}")
    public ResponseEntity<TecnicoResponse> delete(@PathVariable("tecnicoId") Long tecnicoId) {
        this.tecnicoService.delete(tecnicoId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
