package com.adriano.helpedesk.service;

import com.adriano.helpedesk.domain.Chamado;
import com.adriano.helpedesk.domain.Cliente;
import com.adriano.helpedesk.domain.Tecnico;
import com.adriano.helpedesk.domain.dto.request.ChamadoRequest;
import com.adriano.helpedesk.domain.dto.request.ChamadoUpdateRequest;
import com.adriano.helpedesk.domain.dto.response.ChamadoResponse;
import com.adriano.helpedesk.exception.Message;
import com.adriano.helpedesk.repository.ChamadoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ChamadoService {

    private ChamadoRepository chamadoRepository;

    public ChamadoResponse save(ChamadoRequest chamadoRequest) {

        Chamado chamado = Chamado.of(chamadoRequest);

        Cliente cliente = new Cliente();

        Tecnico tecnico = new Tecnico();

        chamado.addCliente(cliente);

        chamado.addTecnico(tecnico);

        this.chamadoRepository.save(chamado);
        return chamado.toResponse() ;
    }

    public ChamadoResponse findByIdChamado(Long chamadoId) {
        Chamado chamado = this.chamadoRepository.findById(chamadoId).orElseThrow(() -> Message.ID_NOT_FOUND_CHAMADO.asBusinessException());
        return chamado.toResponse();

    }

    public List<ChamadoResponse> findAllChamados(){
        List<Chamado> chamadoList = this.chamadoRepository.findAll();
        List<ChamadoResponse> chamadoResponseList = chamadoList.stream().map(c -> new ChamadoResponse(c)).collect(Collectors.toList());
        return chamadoResponseList;
    }

    @Transactional
    public ChamadoResponse update(Long chamadoId, @Valid ChamadoUpdateRequest chamadoUpdateRequest){
        Chamado chamado = this.chamadoRepository.findById(chamadoId).orElseThrow(() -> Message.ID_NOT_FOUND_CHAMADO.asBusinessException());

        chamado.update(chamadoUpdateRequest);

        return chamado.toResponse();

    }



}
