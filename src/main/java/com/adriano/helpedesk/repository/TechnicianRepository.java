package com.adriano.helpedesk.repository;

import com.adriano.helpedesk.domain.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TechnicianRepository extends JpaRepository<Tecnico, Long> {
      Optional<Tecnico> findByCpf(String cpf);


}
