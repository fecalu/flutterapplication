package io.github.fecalu.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class ContatoUpdateDTO {

    @NotNull(message = "Id é obrigatório")
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Sobrenome é obrigatório")
    private String sobrenome;

    private LocalDate dataNascimento;

    @NotBlank(message = "E-mail não pode estar vazio")
    @Email(message = "Formato de e-mail inválido")
    private String email;

    @NotBlank(message = "Número de telefone é obrigatório")
    private String numeroTelefone;

    @NotNull(message = "Campo isFamilia não pode ser nulo")
    private Boolean isFamilia;

    public ContatoUpdateDTO() {}

    public ContatoUpdateDTO(String nome, String sobrenome, LocalDate dataNascimento, String email, String numeroTelefone, Boolean isFamilia) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.numeroTelefone = numeroTelefone;
        this.isFamilia = isFamilia;
    }

    public ContatoUpdateDTO(Long id, String nome, String sobrenome, LocalDate dataNascimento, String email, String numeroTelefone, Boolean isFamilia) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.numeroTelefone = numeroTelefone;
        this.isFamilia = isFamilia;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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

    public void setIsFamilia(Boolean familia) {
        isFamilia = familia;
    }
}
