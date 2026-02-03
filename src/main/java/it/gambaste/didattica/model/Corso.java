package it.gambaste.didattica.model;

import java.time.LocalDate;

public class Corso {
    private int id;
    private String nome;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private Docente insegnanti;

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

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    public Docente getInsegnanti() {
        return insegnanti;
    }

    public void setInsegnanti(Docente insegnanti) {
        this.insegnanti = insegnanti;
    }
}
