package com.adriano.helpedesk.controller;

import com.adriano.helpedesk.domain.dto.request.TecnicoRequest;
import com.adriano.helpedesk.domain.dto.response.TecnicoResponse;
import com.adriano.helpedesk.service.TecnicoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "helpdesk Endpoint", description = "HelpDesk", tags = { "Tecnico Endpoint" })
@RestController
@AllArgsConstructor
@RequestMapping("/tecnicos")
public class TecnicoController {


    private TecnicoService tecnicoService;

    @ApiOperation(value = "Busca tecnico por id")
    @GetMapping("/{tecnicoId}")
    public ResponseEntity<TecnicoResponse> findById(@PathVariable("tecnicoId") Long tecnicoId) {
        return ResponseEntity.status(HttpStatus.OK).body(this.tecnicoService.findById(tecnicoId));
    }

    @ApiOperation(value = "Busca todos os tecnicos")
    @GetMapping
    public ResponseEntity<List<TecnicoResponse>> findAllTecnico() {
        return ResponseEntity.status(HttpStatus.OK).body(this.tecnicoService.findAllTecnico());
    }
    @ApiOperation(value = "Cria um novo tecnico")
    @PostMapping
    public ResponseEntity<TecnicoResponse> createTecnico(@RequestBody TecnicoRequest tecnicoRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.tecnicoService.createTecnico(tecnicoRequest));
    }

    @ApiOperation(value = "Atualiza o tecnico por id")
    @PutMapping("/{tecnicoId}")
    public ResponseEntity<TecnicoResponse> update(@PathVariable("tecnicoId") Long tecnicoId, @RequestBody TecnicoRequest tecnicoRequest){
        return ResponseEntity.status(HttpStatus.OK).body(this.tecnicoService.update(tecnicoId,tecnicoRequest));
    }

    @ApiOperation(value = "Exclusão de tecnico por id")
    @DeleteMapping("/{tecnicoId}")
    public ResponseEntity<TecnicoResponse> delete(@PathVariable("tecnicoId") Long tecnicoId) {
        this.tecnicoService.delete(tecnicoId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
