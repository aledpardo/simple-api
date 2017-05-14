package io.swagger.service;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.api.ApiException;
import io.swagger.model.Constants;
import io.swagger.model.Usuario;
import io.swagger.repository.UsuarioRepository;

@Service
public class LoginService implements Login {

	private final UsuarioRepository usuarioRepository;
	
	@Autowired
	public LoginService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	@Override
	public Usuario loginUser(io.swagger.model.Login login) throws ApiException {
		if (login == null || login.getEmail() == null || login.getPassword() == null) {
			throw new ApiException(HttpStatus.BAD_REQUEST.value(), Constants.EMPTY);
		}
		
		Usuario usuario = this.usuarioRepository.findUsuario(login);
		
		if (usuario == null) {
			throw new ApiException(HttpStatus.BAD_REQUEST.value(), Constants.USUARIO_SENHA_INVALIDOS);
		}
		
		if (usuario.getDadosUsuario().getPassword().equals(login.getPassword())){
			return usuario.lastLogin(new DateTime());
		}

		throw new ApiException(HttpStatus.BAD_REQUEST.value(), Constants.USUARIO_SENHA_INVALIDOS);
	}
}
