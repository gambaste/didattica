package it.gambaste.didattica.rs;


import it.gambaste.didattica.business.MateriaManager;
import it.gambaste.didattica.dto.MateriaResponseDto;
import it.gambaste.didattica.model.Materia;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/materie")
public class MateriaResource {

    //CREATE
    @POST
    @Path("/")
    public Response createMateria(MateriaRequestDto materia) {
        boolean inserted = MateriaManager.insertMateria(materia);
        if (inserted) {
            return ResponseUtil.ok("Materia inserted");
        }
        return ResponseUtil.badRequest("Materia NOT inserted");
    }

    //READ
    @GET
    @Path("/{id}")
    public Response getMateria(@PathParam("id") Integer id) {
        MateriaResponseDto materia = MateriaManager.getMateriaDto(id);
        if (materia == null) {
            return ResponseUtil.notFound("Materia not found");
        }
        return ResponseUtil.ok(materia);
    }

    //UPDATE
    @PUT
    @Path("/{id}")
    public  Response updateMateria(@PathParam("id") Integer id, MateriaRequestDto materia) {
        boolean updated = MateriaManager.updateMateria(id, materia);
        if (updated) {
            return ResponseUtil.ok("Materia updated");
        }
        return ResponseUtil.badRequest("Materia NOT updated");
    }

    //DELETE
    @DELETE
    @Path("/{id}")
    public Response deleteMateria(@PathParam("id") Integer id) {
        boolean deleted = MateriaManager.deleteMateria(id);
        if (deleted) {
            return ResponseUtil.ok("Materia deleted");
        }
        return ResponseUtil.badRequest("Materia NOT deleted");
    }
}
