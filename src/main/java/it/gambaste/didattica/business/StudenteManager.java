package it.gambaste.didattica.business;

import it.gambaste.didattica.dao.StudenteDao;
import it.gambaste.didattica.dto.CorsoResponseDto;
import it.gambaste.didattica.dto.StudenteResponseDto;
import it.gambaste.didattica.dto.StudenteRequestDto;
import it.gambaste.didattica.model.Corso;
import it.gambaste.didattica.model.Studente;

import java.util.HashSet;
import java.util.Set;

public class StudenteManager {

    public static StudenteResponseDto getStudente(Integer id) {
        StudenteResponseDto stud = null;

        StudenteDao dao = new StudenteDao();
        Studente s = dao.get(id);

        if (s != null) {
            stud = new StudenteResponseDto();
            stud.setNome(s.getNome());
            stud.setCognome(s.getCognome());
            stud.setEmail(s.getEmail());
        }
        return stud;
    }

    public static boolean deleteStudente(Integer id) {
        StudenteDao dao = new StudenteDao();
        Studente s = dao.get(id);
        if (s == null) {
            return false;
        }
        dao.remove(id);
        return true;
    }

    public static boolean updateStudente(Integer id, StudenteRequestDto studenteReq) {
        StudenteDao dao = new StudenteDao();
        Studente s = dao.get(id);
        if (s == null) {
            return false;
        }

        boolean isValid = validateStudente(studenteReq);

        if (isValid) {
            s.setNome(studenteReq.getNome());
            s.setCognome(studenteReq.getCognome());
            s.setEmail(studenteReq.getEmail());
            s.setDataNascita(studenteReq.getDataNascita());
            s.setCorsiSeguiti(studenteReq.getCorsiSeguiti());
            dao.set(s);
            return true;
        }

        return false;
    }

    private static boolean validateStudente(StudenteRequestDto studente) {
        if (studente.getNome() == null || studente.getNome().isBlank()) {
            return false;
        }

        if (studente.getCognome() == null || studente.getCognome().isBlank()) {
            return false;
        }

        if (studente.getEmail() == null || studente.getEmail().isBlank()) {
            return false;
        }

        if (studente.getDataNascita() == null ) {
            return false;
        }
        if (studente.getCorsiSeguiti() == null) {
            return true;
        }

        if (!studente.getCorsiSeguiti().isEmpty()) {
            for (Integer idCorso : studente.getCorsiSeguitiId()) {
                CorsoResponseDto cor = CorsoManager.getCorsoDto(idCorso);
                if (cor == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean insertStudente(StudenteRequestDto studente) {
        boolean isValid = validateStudente(studente);
        if (isValid) {
            Studente s = new Studente();
            s.setNome(studente.getNome());
            s.setCognome(studente.getCognome());
            s.setEmail(studente.getEmail());
            s.setDataNascita(studente.getDataNascita());

            if (studente.getCorsiSeguitiId() != null) {
                Set<Corso> corsi = new HashSet<Corso>();
                for (Integer idCorso : studente.getCorsiSeguitiId()) {
                    Corso c = CorsoManager.getCorsoEntity(idCorso);
                    corsi.add(c);
                }
                s.setCorsiSeguiti(corsi);
            }

            StudenteDao dao = new StudenteDao();
            dao.set(s);
            return true;
        }
        return false;

    }
    
}
