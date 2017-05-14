package io.swagger.api;

import io.swagger.model.Usuario;
import java.util.UUID;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-13T22:59:20.852Z")

@Api(value = "perfil", description = "the perfil API")
public interface PerfilApi {

    @ApiOperation(value = "Retorna os dados do usuário", notes = "Retorna o usuário com o UUID fornecido", response = Usuario.class, authorizations = {
        @Authorization(value = "api_key")
    }, tags={ "perfil", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Usuário encontrado", response = Usuario.class),
        @ApiResponse(code = 400, message = "UUID inválido", response = Usuario.class),
        @ApiResponse(code = 401, message = "Não autorizado", response = Usuario.class),
        @ApiResponse(code = 403, message = "Sessão expirada", response = Usuario.class),
        @ApiResponse(code = 404, message = "Usuário não encontrado", response = Usuario.class) })
    @RequestMapping(value = "/perfil/{userUuid}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<Usuario> perfilUsuario(@ApiParam(value = "API Key do usuário") @RequestHeader("api_key") UUID apiKey,
    		@ApiParam(value = "UUID do usuário",required=true ) @PathVariable("userUuid") UUID userUuid);

}
