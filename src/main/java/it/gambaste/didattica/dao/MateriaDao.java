package it.gambaste.didattica.dao;

import it.gambaste.didattica.model.Materia;

import java.util.HashMap;
import java.util.Map;

public class MateriaDao {

    public static Map<Integer, Materia> database = new HashMap<>();

    public MateriaDao() {
        if (database.isEmpty()) {
            Materia materia = new Materia();
            materia.setId(1);
            materia.setNome("Intellij");
            database.put(materia.getId(), materia);

            materia = new Materia();
            materia.setId(1);
            materia.setNome("Postman");
            database.put(materia.getId(), materia);
        }
    }

    public Materia get(int id) {
        return database.get(id);
    }

    public void set(Materia materia) {
        database.put(materia.getId(), materia);
    }

    public void remove(Integer id) {
        database.remove(id);
    }
}
