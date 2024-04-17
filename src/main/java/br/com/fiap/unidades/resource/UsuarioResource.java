package br.com.fiap.unidades.resources;

import br.com.fiap.unidades.dto.ResourceDTO;
import br.com.fiap.unidades.entity.Usuario;
import br.com.fiap.unidades.service.UsuarioService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource implements ResourceDTO<Usuario> {

    @Inject
    private UsuarioService usuarioService;

    @GET
    public List<Usuario> getAll() {
        return usuarioService.getAll();
    }

    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") Long id) {
        Usuario usuario = usuarioService.getById(id);
        if (usuario != null) {
            return Response.ok(usuario).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response create(Usuario usuario) {
        usuarioService.create(usuario);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/username/{username}")
    public List<Usuario> getByUsername(@PathParam("username") String username) {
        return usuarioService.getByUsername(username);
    }

    @GET
    @Path("/pessoaId/{pessoaId}")
    public List<Usuario> getByPessoaId(@PathParam("pessoaId") Long pessoaId) {
        return usuarioService.getByPessoaId(pessoaId);
    }

    @GET
    @Path("/pessoaNome/{nome}")
    public List<Usuario> getByPessoaNome(@PathParam("nome") String nome) {
        return usuarioService.getByPessoaNome(nome);
    }

    @GET
    @Path("/pessoaSobrenome/{sobrenome}")
    public List<Usuario> getByPessoaSobrenome(@PathParam("sobrenome") String sobrenome) {
        return usuarioService.getByPessoaSobrenome(sobrenome);
    }

    @GET
    @Path("/pessoaNascimento/{nascimento}")
    public List<Usuario> getByPessoaNascimento(@PathParam("nascimento") String nascimento) {
        return usuarioService.getByPessoaNascimento(nascimento);
    }

    @GET
    @Path("/pessoaTipo/{tipo}")
    public List<Usuario> getByPessoaTipo(@PathParam("tipo") String tipo) {
        return usuarioService.getByPessoaTipo(tipo);
    }

    @GET
    @Path("/pessoaEmail/{email}")
    public List<Usuario> getByPessoaEmail(@PathParam("email") String email) {
        return usuarioService.getByPessoaEmail(email);
    }
}
