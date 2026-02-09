package it.gambaste.didattica.dao;

import it.gambaste.didattica.model.Corso;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class CorsoDao {

    private static Map<Integer, Corso> database = new HashMap<>();

    public CorsoDao() {
        if (database.isEmpty()) {
            Corso corso = new Corso();
            corso.setId(1);
            corso.setNome("Java");
            corso.setDataInizio(LocalDate.of(2026, 1, 8));
            corso.setDateFine(LocalDate.of(2026, 2, 10));
            database.put(corso.getId(), corso);

            corso = new Corso();
            corso.setId(2);
            corso.setNome("REST");
            corso.setDataInizio(LocalDate.of(2025, 12, 5));
            corso.setDateFine(LocalDate.of(2026, 2, 15));
            database.put(corso.getId(), corso);
        }
    }

    public Corso get(Integer id) {
        return database.get(id);
    }

    public void set(Corso corso) {
        database.put(corso.getId(), corso);
    }

    public void remove(Integer id) {
        database.remove(id);
    }
}
