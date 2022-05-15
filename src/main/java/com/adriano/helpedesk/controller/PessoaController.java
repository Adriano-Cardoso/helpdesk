package com.adriano.helpedesk.controller;

import com.adriano.helpedesk.domain.Pessoa;
import com.adriano.helpedesk.repository.PessoaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Receita Endpoint", description = "Receita", tags = { "Receita Endpoint" })
@RestController
@AllArgsConstructor
@RequestMapping("/pessoa")
public class PessoaController {

    private PessoaRepository pessoaRepository;

    @ApiOperation(value = "Cria uma nova receita")
    @PostMapping
    public ResponseEntity<Pessoa> createRevenue(@RequestBody Pessoa pessoa) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.pessoaRepository.save(pessoa));
    }

}
