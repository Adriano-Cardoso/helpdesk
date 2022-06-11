package com.adriano.helpedesk.repository;

import com.adriano.helpedesk.domain.Pessoa;
import com.adriano.helpedesk.domain.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
