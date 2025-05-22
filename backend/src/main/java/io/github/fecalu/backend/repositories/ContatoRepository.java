package io.github.fecalu.backend.repositories;

import io.github.fecalu.backend.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

    boolean existsByNumeroTelefone(String numeroTelefone);

}
