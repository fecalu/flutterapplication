package io.github.fecalu.backend.dto;

import java.time.LocalDate;

public record ContatoResponseDTO(

        Long id,
        String nome,
        String sobrenome,
        LocalDate dataNascimento,
        String numeroTelefone,
        Boolean isFamilia

) {
}
