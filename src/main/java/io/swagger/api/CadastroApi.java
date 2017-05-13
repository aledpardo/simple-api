package io.swagger.api;

import io.swagger.model.Body;
import io.swagger.model.InlineResponse200;
import io.swagger.model.InlineResponse400;

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

@Api(value = "cadastro", description = "the cadastro API")
public interface CadastroApi {

    @ApiOperation(value = "Cria um novo usuário.", notes = "", response = InlineResponse200.class, tags={ "cadastro", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Usuário cadastrado com sucesso", response = InlineResponse200.class),
        @ApiResponse(code = 400, message = "Requisição má formada", response = InlineResponse200.class),
        @ApiResponse(code = 405, message = "Dados inválidos", response = InlineResponse200.class) })
    @RequestMapping(value = "/cadastro",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<InlineResponse200> addUser(@ApiParam(value = "Dados do usuário para ser cadastrado" ,required=true ) @RequestBody Body body);

}
