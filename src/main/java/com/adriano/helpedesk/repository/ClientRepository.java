package com.adriano.helpedesk.repository;

import com.adriano.helpedesk.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Cliente, Long> {
    Optional<String> findByCpf(String cpf);

    @Query("select e.email From Pessoa e where e.email =:email")
    Optional<String> findByEmail(String email);
}
