
package EE22004.appweb.resources;

import EE22004.appweb.entidades.Materia;
import EE22004.appweb.negocio.DataService2;
import jakarta.ejb.EJB;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/materias")
public class Recurso2 {
    
    @EJB DataService2 servicio2;
    
    @GET
    public Response getMaterias(){
        List<Materia> materias = servicio2.getMaterias();
        return Response.ok(materias).build();
    }
    
    @POST
    public Response saveMateria(Materia materia){
        servicio2.saveMateria(materia);
        return Response.ok("Materia creada exitosamente").build();
    }
    
    @PUT
    public Response editMateria(Materia materia){
        servicio2.editMateria(materia);
        return Response.ok("Materia editada exitosamente").build();
    }
    
    @DELETE
    @Path("/{id_materia}")
    public Response deleteMateria(@PathParam("id_materia") Long id_materia){
        servicio2.deleteMateria(new Materia(id_materia));
        return Response.ok("Materia eliminada exitosamente").build();
    }
}
