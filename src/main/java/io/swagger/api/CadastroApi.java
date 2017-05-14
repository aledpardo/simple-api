package io.swagger.api;

import io.swagger.model.DadosUsuario;
import io.swagger.model.ModelApiResponse;
import io.swagger.model.Usuario;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-13T22:59:20.852Z")

@Api(value = "cadastro", description = "the cadastro API")
public interface CadastroApi {

    @ApiOperation(value = "Cria um novo usuário.", notes = "", response = Usuario.class, tags={ "cadastro", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Usuário cadastrado com sucesso", response = Usuario.class),
        @ApiResponse(code = 400, message = "Requisição má formada", response = ModelApiResponse.class),
        @ApiResponse(code = 405, message = "Dados inválidos", response = ModelApiResponse.class) })
    @RequestMapping(value = "/cadastro",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Usuario> addUser(@ApiParam(value = "Dados do usuário para ser cadastrado", required=true ) @RequestBody DadosUsuario dadosUsuario);

}
