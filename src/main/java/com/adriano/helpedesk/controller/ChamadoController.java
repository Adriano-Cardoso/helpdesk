package com.adriano.helpedesk.controller;

import com.adriano.helpedesk.domain.Tecnico;
import com.adriano.helpedesk.domain.dto.request.TecnicoRequest;
import com.adriano.helpedesk.domain.dto.response.TecnicoResponse;
import com.adriano.helpedesk.exception.BusinessException;
import com.adriano.helpedesk.service.TecnicoService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "helpdesk Endpoint", description = "HelpDesk", tags = { "Tecnico Endpoint" })
@RestController
@AllArgsConstructor
@RequestMapping("/tecnico")
public class TecnicosController {


    private TecnicoService tecnicoService;

    @GetMapping("/{tecnicoId}")
    public ResponseEntity<Tecnico> findById(@PathVariable("tecnicoId") Long tecnicoId) throws BusinessException {
        return ResponseEntity.status(HttpStatus.OK).body(this.tecnicoService.findById(tecnicoId));
    }

    @PostMapping
    public ResponseEntity<TecnicoResponse> save(@RequestBody TecnicoRequest tecnico) throws BusinessException {
        return ResponseEntity.status(HttpStatus.OK).body(this.tecnicoService.save(tecnico));
    }
}
