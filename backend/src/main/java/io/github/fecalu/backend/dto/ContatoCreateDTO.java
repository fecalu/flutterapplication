package io.github.fecalu.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class ContatoCreateDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Sobrenome é obrigatório")
    private String sobrenome;

    @NotBlank(message = "E-mail não pode estar vazio")
    @Email(message = "Formato de e-mail inválido")
    private String email;

    private LocalDate dataNascimento;

    @NotBlank(message = "Número de telefone é obrigatório")
    private String numeroTelefone;

    private Boolean isFamilia = false;

    public ContatoCreateDTO() {}

    public ContatoCreateDTO(String nome, String sobrenome, String email, LocalDate dataNascimento, String numeroTelefone, Boolean isFamilia) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getFamilia() {
        return isFamilia;
    }

    public void setFamilia(Boolean familia) {
        isFamilia = familia;
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
}
