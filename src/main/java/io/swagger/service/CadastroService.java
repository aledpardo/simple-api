package io.swagger.service;

import java.util.Date;
import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import io.swagger.api.ApiException;
import io.swagger.model.Constants;
import io.swagger.model.Usuario;
import io.swagger.model.DadosUsuario;

@Service
public class CadastroService implements Cadastro {

	private static final String DADOS_INVALIDOS = "Verifique os dados. Todos os campos são requeridos.";
	
	@Override
	public Usuario addUser(DadosUsuario dadosUsuario) throws ApiException {
		if ((dadosUsuario == null)
				|| (dadosUsuario.getName() == null || dadosUsuario.getName().equals(Constants.EMPTY))
				|| (dadosUsuario.getEmail() == null || dadosUsuario.getEmail().equals(Constants.EMPTY))
				|| (dadosUsuario.getPassword() == null || dadosUsuario.getPassword().equals(Constants.EMPTY))
				|| (dadosUsuario.getPhones() == null || dadosUsuario.getPhones().isEmpty())) {
			throw new ApiException(HttpStatus.BAD_REQUEST.value(), DADOS_INVALIDOS);
		}
		
		DateTime now = new DateTime();
		
		return new Usuario()
				.dadosUsuario(dadosUsuario)
				.id(UUID.randomUUID())
				.created(now)
				.modified(now)
				.lastLogin(now)
				.apiKey(UUID.randomUUID());
	}

}
