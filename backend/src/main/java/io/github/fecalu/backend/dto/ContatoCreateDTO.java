package io.github.fecalu.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record ContatoCreateDTO(

        @NotBlank(message = "Nome é obrigatório")
        String nome,

        @NotBlank(message = "Sobrenome é obrigatório")
        String sobrenome,

        @DateTimeFormat(pattern = "dd/MM/yyyy")
        LocalDate dataNascimento,

        @NotBlank(message = "Número de telefone é obrigatório")
        String numeroTelefone,

        @NotNull(message = "Campo isFamilia não pode ser nulo")
        Boolean isFamilia

) {
}
