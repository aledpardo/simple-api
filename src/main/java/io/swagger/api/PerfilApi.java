package io.swagger.api;

import io.swagger.model.InlineResponse200;
import io.swagger.model.InlineResponse400;
import java.util.UUID;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-13T22:59:20.852Z")

@Api(value = "perfil", description = "the perfil API")
public interface PerfilApi {

    @ApiOperation(value = "Retorna os dados do usuário", notes = "Returns a single pet", response = InlineResponse200.class, authorizations = {
        @Authorization(value = "api_key")
    }, tags={ "perfil", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Usuário encontrado", response = InlineResponse200.class),
        @ApiResponse(code = 400, message = "UUID inválido", response = InlineResponse200.class),
        @ApiResponse(code = 401, message = "Não autorizado", response = InlineResponse200.class),
        @ApiResponse(code = 403, message = "Sessão expirada", response = InlineResponse200.class),
        @ApiResponse(code = 404, message = "Usuário não encontrado", response = InlineResponse200.class) })
    @RequestMapping(value = "/perfil/{userUuid}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<InlineResponse200> perfilUsuario(@ApiParam(value = "UUID do usuário",required=true ) @PathVariable("userUuid") UUID userUuid);

}
