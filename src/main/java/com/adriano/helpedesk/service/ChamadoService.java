package com.adriano.helpedesk.service;

import com.adriano.helpedesk.domain.Chamado;
import com.adriano.helpedesk.domain.Cliente;
import com.adriano.helpedesk.domain.Tecnico;
import com.adriano.helpedesk.domain.dto.request.ChamadoRequest;
import com.adriano.helpedesk.domain.dto.response.ChamadoResponse;
import com.adriano.helpedesk.repository.ChamadoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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


}
