package it.gambaste.didattica.rs;

import it.gambaste.didattica.business.CorsoManager;
import it.gambaste.didattica.business.DocenteManager;
import it.gambaste.didattica.dto.CorsoRequestDto;
import it.gambaste.didattica.dto.CorsoResponseDto;
import it.gambaste.didattica.dto.DocenteRequestDto;
import it.gambaste.didattica.dto.DocenteResponseDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/docenti")
public class DocenteResource {

    // CREATE
    @POST
    @Path("/")
    public Response insertDocente(DocenteRequestDto docente) {
        boolean inserted = DocenteManager.insertDocente(docente);
        if (inserted) {
            return ResponseUtil.ok("Docente salvato con successo");
        }

        return ResponseUtil.badRequest("Errore nel salvataggio");
    }

    // READ
    @GET
    @Path("/{id}")
    public Response getDocente(@PathParam("id") Integer id) {
        DocenteResponseDto docente = DocenteManager.getDocente(id);
        if (docente == null) {
            return ResponseUtil.notFound("Il docente non esiste");
        }

        return ResponseUtil.ok(docente);
    }

    // UPDATE
    @PUT
    @Path("/{id}")
    public Response updateDocente(@PathParam("id") Integer id, DocenteRequestDto docente) {
        boolean updated = DocenteManager.updateDocente(id, docente);
        if (updated) {
            return ResponseUtil.ok("Docente salvato con successo");
        }

        return ResponseUtil.badRequest("Errore nel salvataggio");
    }

    // DELETE
    @DELETE
    @Path("/{id}")
    public Response deleteDocente(@PathParam("id") Integer id) {
        boolean deleted = DocenteManager.deleteDocente(id);
        if (deleted) {
            return ResponseUtil.noContent();
        }

        return ResponseUtil.notFound("Il docente non esiste");
    }

}
