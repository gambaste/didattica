package it.gambaste.didattica.dao;

import it.gambaste.didattica.model.Studente;
import it.gambaste.didattica.model.Studente;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class StudenteDao {

    private static Map<Integer, Studente> database = new HashMap<>();

    public StudenteDao() {
        if (database.isEmpty()) {
            Studente studente = new Studente();
            studente.setId(1);
            studente.setNome("Carlo");
            studente.setCognome("Scarpa");
            studente.setEmail("carlo@gmail.com");
            studente.setDataNascita(LocalDate.now());
            database.put(studente.getId(), studente);

            studente = new Studente();
            studente.setId(2);
            studente.setNome("Pippo");
            studente.setCognome("Disney");
            studente.setEmail("pippo@gmail.com");
            studente.setDataNascita(LocalDate.now());
            database.put(studente.getId(), studente);
        }
    }

    public Studente get(Integer id) {
        return database.get(id);
    }

    public Integer set(Studente studente) {
        Random rand = new Random();
        // Genera un numero casuale tra 0 e 999
        Integer id = rand.nextInt(1000);
        database.put(id, studente);
        return id;
    }

    public void remove(Integer id) {
        database.remove(id);
    }
}
