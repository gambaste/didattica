package it.gambaste.didattica.model;

import java.time.LocalDate;
import java.util.Set;

public class Studente {
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataNascita;
    private Set<Corso> corsiSeguiti;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public Set<Corso> getCorsiSeguiti() {
        return corsiSeguiti;
    }

    public void setCorsiSeguiti(Set<Corso> corsiSeguiti) {
        this.corsiSeguiti = corsiSeguiti;
    }
}
