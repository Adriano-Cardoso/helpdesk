package com.adriano.helpedesk.repository;

import com.adriano.helpedesk.domain.Profiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profiles, Long> {
    Optional<Profiles> findByName(String profile);
}
