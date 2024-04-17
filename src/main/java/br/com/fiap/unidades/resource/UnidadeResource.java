package br.com.fiap.unidades.resources;

import br.com.fiap.unidades.dto.ResourceDTO;
import br.com.fiap.unidades.entity.Unidade;
import br.com.fiap.unidades.service.UnidadeService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("unidade")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UnidadeResource implements ResourceDTO<Unidade> {

    @Inject
    private UnidadeService unidadeService;

    @GET
    public List<Unidade> getAll() {
        return unidadeService.getAll();
    }

    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") Long id) {
        Unidade unidade = unidadeService.getById(id);
        if (unidade != null) {
            return Response.ok(unidade).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response create(Unidade unidade) {
        unidadeService.create(unidade);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/nome/{nome}")
    public List<Unidade> getByNome(@PathParam("nome") String nome) {
        return unidadeService.getByNome(nome);
    }

    @GET
    @Path("/sigla/{sigla}")
    public List<Unidade> getBySigla(@PathParam("sigla") String sigla) {
        return unidadeService.getBySigla(sigla);
    }

    @GET
    @Path("/macro/{macroId}")
    public List<Unidade> getByMacroId(@PathParam("macroId") Long macroId) {
        return unidadeService.getByMacroId(macroId);
    }
}
