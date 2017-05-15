package io.swagger.repository;

import java.util.UUID;

import io.swagger.api.ApiException;
import io.swagger.model.Login;
import io.swagger.model.Usuario;

public interface Cadastro {

	CadastroRepository addUsuario(Usuario usuario) throws ApiException;
	
	Usuario findUsuario(UUID id);
	
	Usuario findUsuario(Login login);

	Usuario findApiKey(UUID apiKey);
}
