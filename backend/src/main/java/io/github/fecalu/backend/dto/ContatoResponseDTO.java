package io.github.fecalu.backend.dto;

import java.time.LocalDate;

public class ContatoResponseDTO {

    private Long id;
    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;
    private String numeroTelefone;
    private Boolean isFamilia;

    public ContatoResponseDTO() {}

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
