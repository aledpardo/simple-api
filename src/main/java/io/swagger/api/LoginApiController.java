package io.swagger.api;

import io.swagger.model.Constants;
import io.swagger.model.Login;
import io.swagger.model.ModelApiResponse;
import io.swagger.model.Usuario;
import io.swagger.service.LoginService;
import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-13T22:59:20.852Z")

@Controller
public class LoginApiController implements LoginApi {
	
	private final LoginService loginService;
	
	@Autowired
	public LoginApiController(LoginService loginService) {
		this.loginService = loginService;
	}
	
    public ResponseEntity<Usuario> loginUser(@ApiParam(value = "Dados de acesso do usuário", required=true) @RequestBody Login login) {
        try {
			return new ResponseEntity<Usuario>(this.loginService.loginUser(login), HttpStatus.OK);
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
