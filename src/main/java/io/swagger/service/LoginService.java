package io.swagger.service;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.api.ApiException;
import io.swagger.crypto.Password;
import io.swagger.model.Constants;
import io.swagger.model.Usuario;
import io.swagger.repository.CadastroRepository;
import io.swagger.util.Validacao;

@Service
public class LoginService implements Login {

	private final io.swagger.repository.Cadastro cadastroRepository;
	
	@Autowired
	public LoginService(io.swagger.repository.Cadastro cadastroRepository) {
		this.cadastroRepository = cadastroRepository;
	}
	
	@Override
	public Usuario loginUser(io.swagger.model.Login login) throws ApiException {
		// Validações triviais
		if (login == null
				|| login.getEmail() == null || login.getEmail().length() == 0
				|| Validacao.EmailInvalido(login.getEmail())
				|| login.getPassword() == null || login.getPassword().length() == 0) {
			throw new ApiException(HttpStatus.BAD_REQUEST.value(), Constants.EMPTY);
		}
		
		// Busca o usuário
		Usuario usuario = this.cadastroRepository.findUsuario(login);
		
		// Não achou, retorna mensagem padrão
		if (usuario == null) {
			throw new ApiException(HttpStatus.BAD_REQUEST.value(), Constants.USUARIO_SENHA_INVALIDOS);
		}
		
		try {
			if (Password.check(login.getPassword(), usuario.getDadosUsuario().getPassword())){
				// Atualiza a hora do último login
				usuario.lastLogin(new DateTime());
				
				// Clona o objeto
				Usuario retorno = usuario.clone();
				
				// remove a senha, para não retornar na resposta do request
				retorno.getDadosUsuario().password(null);
				
				return retorno;
			}
		} catch (Exception e) {
			throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR.value(), Constants.ERRO_DESCONHECIDO);
		}

		// Senha incorreta, retorna mensagem padrão
		throw new ApiException(HttpStatus.BAD_REQUEST.value(), Constants.USUARIO_SENHA_INVALIDOS);
	}
}
