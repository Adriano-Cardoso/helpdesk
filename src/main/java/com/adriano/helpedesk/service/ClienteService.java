package com.adriano.helpedesk.service;

import com.adriano.helpedesk.domain.Cliente;
import com.adriano.helpedesk.domain.dto.request.ClienteRequest;
import com.adriano.helpedesk.domain.dto.request.ClienteUpdateRequest;
import com.adriano.helpedesk.domain.dto.response.ClienteResponse;
import com.adriano.helpedesk.exception.Message;
import com.adriano.helpedesk.repository.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
public class ClienteService {

    private ClientRepository clientRepository;

    private BCryptPasswordEncoder encoder;

    public ClienteResponse findById(Long clienteId) {
        Cliente cliente = this.clientRepository.findById(clienteId)
                .orElseThrow(Message.ID_NOT_FOUND::asBusinessException);

        log.info("method=findById clienteId={}", clienteId);

        return cliente.toResponse();
    }


    public ClienteResponse createCliente(@Valid ClienteRequest clienteRequest) {

        this.clientRepository.findByCpf(clienteRequest.getCpf()).ifPresent(c -> {
            throw Message.EXISTING_CPF.asBusinessException();
        });

        Cliente cliente = Cliente.of(clienteRequest);
        cliente.setSenha(encoder.encode(cliente.getSenha()));
        cliente = this.clientRepository.save(cliente);

        log.info("method=createCliente pessoaId={} nome={} cpf={} email={} senha={} dataCriacao={} perfis={}",
                cliente.getPessoaId(), cliente.getNome(), cliente.getCpf(), cliente.getEmail(),
                cliente.getSenha(), cliente.getDataCriacao(), cliente.getPerfis());

        return cliente.toResponse();
    }

    public List<ClienteResponse> findAllCliente() {
        List<Cliente> list = this.clientRepository.findAll();
        return list.stream().map(obj -> obj.toResponse()).collect(Collectors.toList());
    }

    @Transactional
    public ClienteResponse update(Long clienteId, @Valid ClienteUpdateRequest clienteRequest) {
        Cliente cliente = this.clientRepository.findById(clienteId)
                .orElseThrow(() -> Message.ID_NOT_FOUND.asBusinessException());

        log.info("method=findById clienteId={}", clienteId);

        cliente.update(clienteRequest);

        return cliente.toResponse();
    }

    public void delete(Long clienteId) {
        Cliente cliente = this.clientRepository.findById(clienteId)
                .orElseThrow(Message.ID_NOT_FOUND::asBusinessException);
        log.info("method=findById clienteId={}", clienteId);

        log.info("method=delete id={}", clienteId);

        this.clientRepository.delete(cliente);

    }

    public String FindByEmail(String email){
        clientRepository.findByEmail(email).ifPresent(c -> {
            throw Message.EMAIL_EXISTS.asBusinessException();
        });

        return email;
    }

}





