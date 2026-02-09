package it.gambaste.didattica.rs;

import it.gambaste.didattica.business.CorsoManager;
import it.gambaste.didattica.dto.CorsoRequestDto;
import it.gambaste.didattica.dto.CorsoResponseDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/corsi")
public class CorsoResource {

    // CREATE
    @POST
    @Path("/")
    public Response insertCorso(CorsoRequestDto corso) {
        boolean inserted = CorsoManager.insertCorso(corso);
        if (inserted) {
            return ResponseUtil.ok("Corso salvato con successo");
        }

        return ResponseUtil.badRequest("Errore nel salvataggio");
    }

    // READ
    @GET
    @Path("/{id}")
    public Response getCorso(@PathParam("id") Integer id) {
        CorsoResponseDto corso = CorsoManager.getCorsoDto(id);
        if (corso == null) {
            return ResponseUtil.notFound("Il corso non esiste");
        }

        return ResponseUtil.ok(corso);
    }

    // UPDATE
    @PUT
    @Path("/{id}")
    public Response updateCorso(@PathParam("id") Integer id, CorsoRequestDto corso) {
        boolean updated = CorsoManager.updateCorso(id, corso);
        if (updated) {
            return ResponseUtil.ok("Corso salvato con successo");
        }

        return ResponseUtil.badRequest("Errore nel salvataggio");
    }

    // DELETE
    @DELETE
    @Path("/{id}")
    public Response deleteCorso(@PathParam("id") Integer id) {
        boolean deleted = CorsoManager.deleteCorso(id);
        if (deleted) {
            return ResponseUtil.noContent();
        }

        return ResponseUtil.notFound("Il corso non esiste");
    }
}
