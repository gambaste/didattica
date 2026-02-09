package it.gambaste.didattica.model;

import java.time.LocalDate;
import java.util.Set;

public class Corso {
    private Integer id;
    private String nome;
    private LocalDate dataInizio, dateFine;
    private Set<Docente> insegnanti;

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

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDateFine() {
        return dateFine;
    }

    public void setDateFine(LocalDate dateFine) {
        this.dateFine = dateFine;
    }

    public Set<Docente> getInsegnanti() {
        return insegnanti;
    }

    public void setInsegnanti(Set<Docente> insegnanti) {
        this.insegnanti = insegnanti;
    }
}
