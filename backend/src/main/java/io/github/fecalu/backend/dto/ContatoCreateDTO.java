package io.github.fecalu.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class ContatoCreateDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Sobrenome é obrigatório")
    private String sobrenome;

    private LocalDate dataNascimento;

    @NotBlank(message = "Número de telefone é obrigatório")
    private String numeroTelefone;

    @NotNull(message = "Campo isFamilia não pode ser nulo")
    private Boolean isFamilia;

    public ContatoCreateDTO() {}

    public ContatoCreateDTO(String nome, String sobrenome, LocalDate dataNascimento, String numeroTelefone, Boolean isFamilia) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.numeroTelefone = numeroTelefone;
        this.isFamilia = isFamilia;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }
    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public Boolean getIsFamilia() {
        return isFamilia;
    }
    public void setIsFamilia(Boolean isFamilia) {
        this.isFamilia = isFamilia;
    }
}
