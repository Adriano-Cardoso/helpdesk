package com.adriano.helpedesk.controller;

import com.adriano.helpedesk.domain.Tecnico;
import com.adriano.helpedesk.domain.dto.request.ChamadoRequest;
import com.adriano.helpedesk.domain.dto.request.TecnicoRequest;
import com.adriano.helpedesk.domain.dto.response.ChamadoResponse;
import com.adriano.helpedesk.domain.dto.response.TecnicoResponse;
import com.adriano.helpedesk.exception.BusinessException;
import com.adriano.helpedesk.service.ChamadoService;
import com.adriano.helpedesk.service.TecnicoService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "helpdesk Endpoint", description = "HelpDesk", tags = {"Chamado Endpoint"})
@RestController
@AllArgsConstructor
@RequestMapping("/chamado")
public class ChamadoController {


    private ChamadoService chamadoService;

    @PostMapping
    public ResponseEntity<ChamadoResponse> save(@RequestBody ChamadoRequest chamado) throws BusinessException {
        return ResponseEntity.status(HttpStatus.OK).body(this.chamadoService.save(chamado));
    }
}
