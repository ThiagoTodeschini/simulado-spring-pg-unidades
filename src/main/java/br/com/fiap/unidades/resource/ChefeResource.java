package br.com.fiap.unidades.resources;

import br.com.fiap.unidades.dto.ResourceDTO;
import br.com.fiap.unidades.entity.Chefe;
import br.com.fiap.unidades.service.ChefeService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("chefe")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ChefeResource implements ResourceDTO<Chefe> {

    @Inject
    private ChefeService chefeService;

    @GET
    public List<Chefe> getAll() {
        return chefeService.getAll();
    }

    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") Long id) {
        Chefe chefe = chefeService.getById(id);
        if (chefe != null) {
            return Response.ok(chefe).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response create(Chefe chefe) {
        chefeService.create(chefe);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/usuario/{usuarioId}")
    public List<Chefe> getByUsuarioId(@PathParam("usuarioId") Long usuarioId) {
        return chefeService.getByUsuarioId(usuarioId);
    }

    @GET
    @Path("/substituto/{substituto}")
    public List<Chefe> getBySubstituto(@PathParam("substituto") Boolean substituto) {
        return chefeService.getBySubstituto(substituto);
    }

    @GET
    @Path("/unidade/{unidadeId}")
    public List<Chefe> getByUnidadeId(@PathParam("unidadeId") Long unidadeId) {
        return chefeService.getByUnidadeId(unidadeId);
    }
}
