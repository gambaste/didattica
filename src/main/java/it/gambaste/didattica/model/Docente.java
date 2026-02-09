package it.gambaste.didattica.model;

import java.util.Set;

public class Docente {
    private Integer id;
    private String nome, cognome;
    private String email;
    private Set<Materia> materieInsegnate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Materia> getMaterieInsegnate() {
        return materieInsegnate;
    }

    public void setMaterieInsegnate(Set<Materia> materieInsegnate) {
        this.materieInsegnate = materieInsegnate;
    }
}
