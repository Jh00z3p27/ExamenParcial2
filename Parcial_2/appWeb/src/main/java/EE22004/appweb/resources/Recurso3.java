package EE22004.appweb.resources;

import EE22004.appweb.entidades.Inscripcion;
import EE22004.appweb.negocio.DataService3;
import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("inscripciones")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Recurso3 {

    @EJB
    private DataService3 servicio3;

    @GET
    public List<Inscripcion> getInscripciones() {
        return servicio3.getInscripciones();
    }

    @POST
    public Response addInscripcion(Inscripcion inscripcion) {
        servicio3.saveInscripcion(inscripcion);
        return Response.status(Response.Status.CREATED).entity(inscripcion).build();
    }

    @PUT
    @Path("{id}")
    public Response updateInscripcion(@PathParam("id") Long id, Inscripcion inscripcion) {
        Inscripcion existingInscripcion = servicio3.getInscripciones().stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (existingInscripcion == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        inscripcion.setId(id);
        servicio3.editInscripcion(inscripcion);
        return Response.ok(inscripcion).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteInscripcion(@PathParam("id") Long id) {
        Inscripcion inscripcion = servicio3.getInscripciones().stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (inscripcion == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        servicio3.deleteInscripcion(inscripcion);
        return Response.noContent().build();
    }
}
