package it.gambaste.didattica.dto;

import it.gambaste.didattica.model.Corso;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class StudenteRequestDto {
    private String nome, cognome;
    private String email;
    private LocalDate dataNascita;
    private Set<Corso> corsiSeguiti;

    public List<Integer> getCorsiSeguitiId() {
        List<Integer> corsiSeguitiId = new ArrayList<>();
        for (Corso corso : corsiSeguiti) {
            corsiSeguitiId.add(corso.getId());
        }
        return corsiSeguitiId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public void setCorsiSeguiti(Set<Corso> corsiSeguiti) {
        this.corsiSeguiti = corsiSeguiti;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public Set<Corso> getCorsiSeguiti() {
        return corsiSeguiti;
    }
}
