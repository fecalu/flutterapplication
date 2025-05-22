package io.github.fecalu.backend.dto;

import java.time.LocalDate;

public class ContatoResponseDTO {

    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private LocalDate dataNascimento;
    private String numeroTelefone;
    private Boolean isFamilia;

    public ContatoResponseDTO() {}

    public ContatoResponseDTO(Long id, String nome, String sobrenome, String email, LocalDate dataNascimento, String numeroTelefone, Boolean isFamilia) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.dataNascimento = dataNascimento;
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

    public Boolean getFamilia() {
        return isFamilia;
    }

    public void setFamilia(Boolean familia) {
        isFamilia = familia;
    }
}
