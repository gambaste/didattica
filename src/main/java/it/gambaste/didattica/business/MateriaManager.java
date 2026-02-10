package it.gambaste.didattica.business;

import it.gambaste.didattica.dao.MateriaDao;
import it.gambaste.didattica.dto.MateriaResponseDto;
import it.gambaste.didattica.model.Materia;

public class MateriaManager {

    public static MateriaResponseDto getMateriaDto(Integer id) {
        MateriaResponseDto res = null;

        MateriaDao dao = new MateriaDao();
        Materia m = dao.get(id);
        if (m != null) {
            res  = new MateriaResponseDto();
            res.setNome(m.getNome());
        }
        return res;
    }

    public static boolean deleteMateria(Integer id) {
        MateriaDao dao = new MateriaDao();
        Materia m = dao.get(id);
            if (m != null) {
                dao.remove(id);
                return true;
            }
        return false;

    }

    public static boolean updateMateria(Integer id, Materia m) {
        MateriaDao dao = new MateriaDao();
        Materia mat = dao.get(id);
        if (mat != null) {
            mat.setNome(m.getNome());
            return true;
        }
        return false;
    }
}
