package io.swagger.api;

import io.swagger.model.Constants;
import io.swagger.model.ModelApiResponse;
import io.swagger.model.Usuario;
import io.swagger.service.Cadastro;

import java.util.UUID;

import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.validation.constraints.*;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-13T22:59:20.852Z")

@Controller
public class PerfilApiController implements PerfilApi {
	
	private final Cadastro cadastroService;

	@Autowired
	public PerfilApiController(Cadastro cadastroService) {
		this.cadastroService = cadastroService;
	}

    public ResponseEntity<Usuario> perfilUsuario(@ApiParam(value = "API Key do usuário", required=true) @RequestHeader("api_key") UUID apiKey,
    		@ApiParam(value = "UUID do usuário", required=true ) @PathVariable("userUuid") UUID userUuid) {
    	try {
            return new ResponseEntity<Usuario>(this.cadastroService.userProfile(userUuid), HttpStatus.OK);
		} catch (ApiException e) {
			ModelApiResponse response = new ModelApiResponse()
					.code(e.getCode())
					.message(e.getMessage());

			return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			ModelApiResponse response = new ModelApiResponse()
					.code(HttpStatus.INTERNAL_SERVER_ERROR.value())
					.message(Constants.ERRO_DESCONHECIDO + " " + e.getMessage());

			return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
}
