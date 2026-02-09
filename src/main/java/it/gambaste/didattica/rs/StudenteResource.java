package it.gambaste.didattica.rs;

import it.gambaste.didattica.business.StudenteManager;
import it.gambaste.didattica.dto.StudenteRequestDto;
import it.gambaste.didattica.dto.StudenteResponseDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/studenti")
public class StudenteResource {

    // CREATE
    @POST
    @Path("/")
    public Response insertStudente(StudenteRequestDto Studente) {
        boolean inserted = StudenteManager.insertStudente(Studente);
        if (inserted) {
            return ResponseUtil.ok("Studente salvato con successo");
        }

        return ResponseUtil.badRequest("Errore nel salvataggio");
    }

    // READ
    @GET
    @Path("/{id}")
    public Response getStudente(@PathParam("id") Integer id) {
        StudenteResponseDto Studente = StudenteManager.getStudente(id);
        if (Studente == null) {
            return ResponseUtil.notFound("Lo Studente non esiste");
        }

        return ResponseUtil.ok(Studente);
    }

    // UPDATE
    @PUT
    @Path("/{id}")
    public Response updateStudente(@PathParam("id") Integer id, StudenteRequestDto Studente) {
        boolean updated = StudenteManager.updateStudente(id, Studente);
        if (updated) {
            return ResponseUtil.ok("Studente salvato con successo");
        }

        return ResponseUtil.badRequest("Errore nel salvataggio");
    }

    // DELETE
    @DELETE
    @Path("/{id}")
    public Response deleteStudente(@PathParam("id") Integer id) {
        boolean deleted = StudenteManager.deleteStudente(id);
        if (deleted) {
            return ResponseUtil.noContent();
        }

        return ResponseUtil.notFound("Il Studente non esiste");
    }
}
