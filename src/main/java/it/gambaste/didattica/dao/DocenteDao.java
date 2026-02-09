package it.gambaste.didattica.dao;

import it.gambaste.didattica.model.Docente;

import java.util.HashMap;
import java.util.Map;

public class DocenteDao {

    private static Map<Integer, Docente> database = new HashMap<>();

    public DocenteDao() {
        if (database.isEmpty()) {
            Docente docente = new Docente();
            docente.setId(1);
            docente.setNome("Nome docente 1");
            docente.setCognome("Cognome docente 1");
            docente.setEmail("d1@email.it");
            database.put(docente.getId(), docente);

            docente = new Docente();
            docente.setId(2);
            docente.setNome("Nome docente 2");
            docente.setCognome("Cognome docente 2");
            docente.setEmail("d2@email.it");
            database.put(docente.getId(), docente);
        }
    }

    public Docente get(Integer id) {
        return database.get(id);
    }

    public void set(Docente docente) {
        database.put(docente.getId(), docente);
    }

    public void remove(Integer id) {
        database.remove(id);
    }
}
