package com.adriano.helpedesk.repository;

import com.adriano.helpedesk.domain.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TechnicianRepository extends JpaRepository<Tecnico, Long> {

//    @Query("select new com.adriano.helpedesk.domain.dto.response.TecnicoResponse(t.id, t.nome, t.cpf, t.email, t.senha, t.dataCriacao, t.perfis) From Tecnico t where t.cpf=:cpf")
    Optional<Tecnico> findByCpf(String cpf);


}
