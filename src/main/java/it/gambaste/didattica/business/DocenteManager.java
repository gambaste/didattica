package it.gambaste.didattica.business;

import it.gambaste.didattica.dao.DocenteDao;
import it.gambaste.didattica.dto.DocenteRequestDto;
import it.gambaste.didattica.dto.DocenteResponseDto;
import it.gambaste.didattica.model.Docente;

public class DocenteManager {

    protected static Docente getDocenteEntity(Integer id) {
        // DocenteDao dao = new DocenteDao();
        // return dao.get(id);

        return new DocenteDao().get(id);
    }

    public static DocenteResponseDto getDocente(Integer id) {
        DocenteResponseDto res = null;

        DocenteDao dao = new DocenteDao();
        Docente d = dao.get(id);

        if (d != null) {
            res = new DocenteResponseDto();
            res.setNome(d.getNome());
            res.setCognome(d.getCognome());
        }

        return res;
    }

    public static boolean deleteDocente(Integer id) {
        DocenteDao dao = new DocenteDao();
        Docente d = dao.get(id);
        if (d == null) {
            return false;
        }

        dao.remove(id);
        return true;
    }

    private static boolean validateDocente(DocenteRequestDto docente) {
        if (docente.getNome() == null || docente.getNome().isBlank() ||
                docente.getCognome() == null || docente.getCognome().isEmpty()) {

            return false;
        }

        return true;
    }

    public static boolean insertDocente(DocenteRequestDto docenteReq) {
        boolean isValid = validateDocente(docenteReq);

        if (isValid) {
            Docente d = new Docente();
            d.setId(99);
            d.setNome(docenteReq.getNome());
            d.setCognome(docenteReq.getCognome());
            d.setEmail(docenteReq.getEmail());

            DocenteDao dao = new DocenteDao();
            dao.set(d);

            return true;
        }

        return false;
    }

    public static boolean updateDocente(Integer id, DocenteRequestDto docenteReq) {
        DocenteDao dao = new DocenteDao();
        Docente d = dao.get(id);
        if (d == null) {
            return false;
        }

        boolean isValid = validateDocente(docenteReq);

        if (isValid) {
            d.setNome(docenteReq.getNome());
            d.setCognome(docenteReq.getCognome());
            d.setEmail(docenteReq.getEmail());

            dao.set(d);
            return true;
        }

        return false;
    }
}
