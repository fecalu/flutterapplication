package io.github.fecalu.backend.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "agenda_contatos")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "sobrenome", nullable = false)
    private String sobrenome;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "numero_telefone", nullable = false, unique = true)
    private String numeroTelefone;

    @Column(name = "is_familia")
    private Boolean isFamilia = false;

    public Contato() {
    }

    public Contato(Long id, String nome, String sobrenome, String email, LocalDate dataNascimento, String numeroTelefone, Boolean isFamilia) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.numeroTelefone = numeroTelefone;
        this.isFamilia = isFamilia;
    }

    public Contato(String nome, String sobrenome, String email, LocalDate dataNascimento, String numeroTelefone, Boolean isFamilia) {
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return Objects.equals(id, contato.id) && Objects.equals(email, contato.email) && Objects.equals(numeroTelefone, contato.numeroTelefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, numeroTelefone);
    }
}
