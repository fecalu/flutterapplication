package io.github.fecalu.backend.repositories;

import io.github.fecalu.backend.model.Contato;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

    boolean existsByNumeroTelefone(String numeroTelefone);

    boolean existsByEmail(String email);

    @Query("SELECT obj FROM Contato obj " +
            "WHERE UPPER(obj.nome) LIKE UPPER(CONCAT('%', :descricao, '%')) " +
            "OR UPPER(obj.sobrenome) LIKE UPPER(CONCAT('%', :descricao, '%')) " +
            "OR obj.numeroTelefone LIKE CONCAT('%', :descricao, '%')")
    Page<Contato> findContatosByDescricao(@Param("descricao") String descricao, Pageable pageable);
}
