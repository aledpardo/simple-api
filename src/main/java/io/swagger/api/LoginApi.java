package io.swagger.api;

import io.swagger.model.Login;
import io.swagger.model.Usuario;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-13T22:59:20.852Z")

@Api(value = "login", description = "the login API")
public interface LoginApi {

    @ApiOperation(value = "Autentica o usuário cadastrado.", notes = "", response = Usuario.class, responseContainer = "List", tags={ "login", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Usuario.class),
        @ApiResponse(code = 400, message = "E-mail ou senha inválidos.", response = Usuario.class) })
    @RequestMapping(value = "/login",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Usuario> loginUser(@ApiParam(value = "Dados de acesso do usuário" ,required=true ) @RequestBody Login login);

}
