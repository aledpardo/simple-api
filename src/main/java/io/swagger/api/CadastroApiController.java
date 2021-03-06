package io.swagger.api;


import io.swagger.annotations.*;

import io.swagger.api.ApiException;
import io.swagger.model.Constants;
import io.swagger.model.DadosUsuario;
import io.swagger.model.ModelApiResponse;
import io.swagger.model.Usuario;
import io.swagger.service.Cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-13T22:59:20.852Z")

@Controller
public class CadastroApiController implements CadastroApi {

	private final Cadastro cadastroService;
	
	@Autowired
	public CadastroApiController(Cadastro cadastroService) {
		this.cadastroService = cadastroService;
	}

    @SuppressWarnings("unchecked")
	public ResponseEntity<Usuario> addUser(@ApiParam(value = "Dados do usuário para ser cadastrado" ,required=true ) @RequestBody DadosUsuario dadosUsuario) {
        try {
        	return new ResponseEntity<Usuario>(this.cadastroService.addUser(dadosUsuario), HttpStatus.OK);
		} catch (ApiException e) {
			ModelApiResponse response = new ModelApiResponse()
					.mensagem(e.getMessage());

			return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			ModelApiResponse response = new ModelApiResponse()
					.mensagem(Constants.ERRO_DESCONHECIDO + " " + e.getMessage());

			return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
}
