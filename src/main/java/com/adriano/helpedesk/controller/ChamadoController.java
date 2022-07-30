package com.adriano.helpedesk.controller;

import com.adriano.helpedesk.domain.dto.request.ChamadoRequest;
import com.adriano.helpedesk.domain.dto.request.ChamadoUpdateRequest;
import com.adriano.helpedesk.domain.dto.response.ChamadoResponse;
import com.adriano.helpedesk.exception.BusinessException;
import com.adriano.helpedesk.service.ChamadoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "helpdesk Endpoint", description = "HelpDesk", tags = {"Chamados Endpoint"})
@RestController
@AllArgsConstructor
@RequestMapping("/chamado")
public class ChamadoController {


    private ChamadoService chamadoService;

    @PostMapping
    public ResponseEntity<ChamadoResponse> save(@RequestBody ChamadoRequest chamadoRequest) throws BusinessException {
        return ResponseEntity.status(HttpStatus.OK).body(this.chamadoService.save(chamadoRequest));
    }

    @ApiOperation(value = "Busca chamado por id")
    @GetMapping("/{chamadoId}")
    public ResponseEntity<ChamadoResponse> findById(@PathVariable("chamadoId") Long chamadoId) {
        return ResponseEntity.status(HttpStatus.OK).body(this.chamadoService.findByIdChamado(chamadoId));
    }

    @ApiOperation(value = "Busca todos os Chamados")
    @GetMapping
    public ResponseEntity<List<ChamadoResponse>> findAllTecnico() {
        return ResponseEntity.status(HttpStatus.OK).body(this.chamadoService.findAllChamados());
    }

    @PatchMapping("/{chamadoId}")
    public ResponseEntity<ChamadoResponse> update(@PathVariable("chamadoId")Long chamadoId, @RequestBody ChamadoUpdateRequest chamadoUpdateRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(this.chamadoService.update(chamadoId, chamadoUpdateRequest));
    }

}
