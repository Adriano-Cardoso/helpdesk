package com.adriano.helpedesk.repository;

import com.adriano.helpedesk.domain.Chamado;
import com.adriano.helpedesk.domain.dto.response.ChamadoResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Long> {

}
