package com.adriano.helpedesk.service;

import com.adriano.helpedesk.domain.Tecnico;
import com.adriano.helpedesk.domain.dto.request.TecnicoRequest;
import com.adriano.helpedesk.domain.dto.response.TecnicoResponse;
import com.adriano.helpedesk.exception.Message;
import com.adriano.helpedesk.repository.TecnicoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Validated
@Slf4j
public class TecnicoService {

    private TecnicoRepository tecnicoRepository;

    public TecnicoResponse findById(Long tecnicoId) {
        Tecnico tecnico = this.tecnicoRepository.findById(tecnicoId)
                .orElseThrow(() -> Message.ID_NOT_FOUND_TECNICO.asBusinessException());

        log.info("method=findById tecnicoId={}", tecnicoId);


        return tecnico.toResponse(tecnico);
    }


    public TecnicoResponse createTecnico(@Valid TecnicoRequest tecnicoRequest) {

        this.tecnicoRepository.findByCpf(tecnicoRequest.getCpf()).ifPresent(c -> {
            throw Message.EXISTING_CPF.asBusinessException();
        });

        Tecnico tecnico = Tecnico.of(tecnicoRequest);

        tecnico = this.tecnicoRepository.save(tecnico);

        log.info("method=createTecnico pessoaId={} nome={} cpf={} email={} senha={} dataCriacao={} perfis={}",
                tecnico.getPessoaId(), tecnico.getNome(), tecnico.getCpf(), tecnico.getEmail(), tecnico.getSenha(), tecnico.getDataCriacao(), tecnico.getPerfis());


        return tecnico.toResponse(tecnico);
    }

    public List<TecnicoResponse> findAllTecnico() {
        List<Tecnico> list = this.tecnicoRepository.findAll();
        return list.stream().map(obj -> obj.toResponse(obj)).collect(Collectors.toList());
    }

    @Transactional
    public TecnicoResponse update(Long tecnicoId, @Valid TecnicoRequest tecnicoRequest){
        Tecnico tecnico = this.tecnicoRepository.findById(tecnicoId)
                .orElseThrow(() -> Message.ID_NOT_FOUND_TECNICO.asBusinessException());

        log.info("method=findById tecnicoId={}", tecnicoId);

        tecnico.update(tecnicoRequest);

        return tecnico.toResponse(tecnico);
    }

    public void delete(Long tecnicoId) {
        Tecnico tecnico = this.tecnicoRepository.findById(tecnicoId)
                .orElseThrow(() -> Message.ID_NOT_FOUND_TECNICO.asBusinessException());
        log.info("method=findById tecnicoId={}", tecnicoId);

        log.info("method=delete id={}", tecnicoId);

        this.tecnicoRepository.delete(tecnico);

    }

}





