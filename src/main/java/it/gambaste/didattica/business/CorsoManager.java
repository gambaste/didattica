package it.gambaste.didattica.business;

import it.gambaste.didattica.dao.CorsoDao;
import it.gambaste.didattica.dto.CorsoRequestDto;
import it.gambaste.didattica.dto.CorsoResponseDto;
import it.gambaste.didattica.dto.DocenteResponseDto;
import it.gambaste.didattica.model.Corso;
import it.gambaste.didattica.model.Docente;

import java.util.HashSet;
import java.util.Set;

public class CorsoManager {

    public static CorsoResponseDto getCorsoDto(Integer id) {
        CorsoResponseDto res = null;

        CorsoDao dao = new CorsoDao();
        Corso c = dao.get(id);

        if (c != null) {
            res = new CorsoResponseDto();
            res.setNome(c.getNome());
        }

        return res;
    }

    public static Corso getCorsoEntity(Integer id) {
        if (id == null)
            return null;

        CorsoDao dao = new CorsoDao();
        return dao.get(id);
    }

    public static boolean deleteCorso(Integer id) {
        CorsoDao dao = new CorsoDao();
        Corso c = dao.get(id);
        if (c == null) {
            return false;
        }

        dao.remove(id);
        return true;
    }

    private static boolean validateCorso(CorsoRequestDto corso) {
        if (corso.getNome() == null || corso.getNome().isBlank()) {
            return false;
        }

        if (corso.getDataInizio() != null && corso.getDataFine() != null) {
            if (corso.getDataInizio().isAfter(corso.getDataFine())) {
                return false;
            }
        }

        if (corso.getDocentiId() != null && !corso.getDocentiId().isEmpty()) {
            for (Integer idDocente : corso.getDocentiId()) {
                DocenteResponseDto docente = DocenteManager.getDocente(idDocente);
                if (docente == null) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean insertCorso(CorsoRequestDto corsoReq) {
        boolean isValid = validateCorso(corsoReq);

        if (isValid) {
            Corso c = new Corso();
            c.setId(99);
            c.setNome(corsoReq.getNome());
            c.setDataInizio(corsoReq.getDataInizio());
            c.setDateFine(corsoReq.getDataFine());

            if (corsoReq.getDocentiId() != null) {
                Set<Docente> docenti = new HashSet<>();

                for (Integer idDocente : corsoReq.getDocentiId()) {
                    Docente docente = DocenteManager.getDocenteEntity(idDocente);
                    docenti.add(docente);
                }

                c.setInsegnanti(docenti);
            }

            CorsoDao dao = new CorsoDao();
            dao.set(c);

            return true;
        }

        return false;
    }

    public static boolean updateCorso(Integer id, CorsoRequestDto corsoReq) {
        CorsoDao dao = new CorsoDao();
        Corso c = dao.get(id);
        if (c == null) {
            return false;
        }

        boolean isValid = validateCorso(corsoReq);

        if (isValid) {
            c.setNome(corsoReq.getNome());
            c.setDataInizio(corsoReq.getDataInizio());
            c.setDateFine(corsoReq.getDataFine());

            dao.set(c);
            return true;
        }

        return false;
    }
}
