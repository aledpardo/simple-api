package io.swagger.service;

import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.api.ApiException;
import io.swagger.crypto.Password;
import io.swagger.model.Constants;
import io.swagger.model.DadosUsuario;
import io.swagger.model.Login;
import io.swagger.model.Usuario;
import io.swagger.util.Validacao;

@Service
public class CadastroService implements Cadastro {
	
	private final io.swagger.repository.Cadastro cadastroRepository;
	
	@Autowired
	public CadastroService(io.swagger.repository.Cadastro cadastroRepository) {
		this.cadastroRepository = cadastroRepository;
	}
	
	@Override
	public Usuario addUser(DadosUsuario dadosUsuario) throws ApiException {
		if ((dadosUsuario == null)
		||  (dadosUsuario.getName() == null || dadosUsuario.getName().equals(Constants.EMPTY))
		||  (dadosUsuario.getEmail() == null || dadosUsuario.getEmail().equals(Constants.EMPTY))
		||  Validacao.EmailInvalido(dadosUsuario.getEmail())
		||  (dadosUsuario.getPassword() == null || dadosUsuario.getPassword().equals(Constants.EMPTY))
		||  (dadosUsuario.getPhones() == null || dadosUsuario.getPhones().isEmpty())) {
			throw new ApiException(HttpStatus.BAD_REQUEST.value(), Constants.DADOS_INVALIDOS);
		}
		
		boolean usuarioJaExiste = this.cadastroRepository
				.findUsuario(
						new Login().email(dadosUsuario.getEmail())) != null;
		
		if (usuarioJaExiste) {
			throw new ApiException(HttpStatus.BAD_REQUEST.value(), Constants.USUARIO_JA_CADASTRADO);
		}
		
		// Gera o hash do password para armazenamento
		String saltedPassword;
		try {
			saltedPassword = Password.getSaltedHash(dadosUsuario.getPassword());
		} catch (Exception e) {
			throw new ApiException(HttpStatus.BAD_REQUEST.value(), Constants.USUARIO_SENHA_INVALIDOS);
		}
		
		dadosUsuario.setPassword(saltedPassword);

		DateTime now = new DateTime();
		
		Usuario usuario = new Usuario()
				.dadosUsuario(dadosUsuario)
				.id(UUID.randomUUID())
				.created(now)
				.modified(now)
				.lastLogin(null)
				.apiKey(UUID.randomUUID()); 
		
		this.cadastroRepository.addUsuario(usuario);
		
		Usuario retorno = usuario.clone();
		
		// Remove do retorno o hash do password
		retorno.getDadosUsuario().password(null);
		
		return retorno;
	}

	@Override
	public Usuario userProfile(UUID apiKey, UUID id) throws ApiException {
		Usuario usuarioApiKey = this.cadastroRepository.findApiKey(apiKey);
		
		if (usuarioApiKey == null) {
			throw new ApiException(HttpStatus.UNAUTHORIZED.value(), Constants.NAO_AUTORIZADO);
		}
		
		Usuario usuario = this.cadastroRepository.findUsuario(id);
		
		if (usuario == null || !usuario.getApiKey().equals(apiKey)) {
			throw new ApiException(HttpStatus.UNAUTHORIZED.value(), Constants.NAO_AUTORIZADO);
		}
		
		if (usuario.getLastLogin() == null || usuario.getLastLogin().isBefore(new DateTime().plusMinutes(-Constants.TRINTA_MINUTOS))) {
			throw new ApiException(HttpStatus.FORBIDDEN.value(), Constants.SESSAO_EXPIRADA);
		}
		
		Usuario retorno = usuario.clone();
		
		// Remove do retorno o hash do password
		retorno.getDadosUsuario().password(null);
		
		return retorno;
	}
}
