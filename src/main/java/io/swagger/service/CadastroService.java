package io.swagger.service;

import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import io.swagger.api.ApiException;
import io.swagger.model.Constants;
import io.swagger.model.Usuario;
import io.swagger.repository.UsuarioRepository;
import io.swagger.model.DadosUsuario;

@Service
public class CadastroService implements Cadastro {

	private static final String DADOS_INVALIDOS = "Verifique os dados. Todos os campos são requeridos.";
	
	private final UsuarioRepository usuarioRepository;
	
	@Autowired
	public CadastroService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	@Override
	public Usuario addUser(DadosUsuario dadosUsuario) throws ApiException {
		if ((dadosUsuario == null)
		||  (dadosUsuario.getName() == null || dadosUsuario.getName().equals(Constants.EMPTY))
		||  (dadosUsuario.getEmail() == null || dadosUsuario.getEmail().equals(Constants.EMPTY))
		||  (dadosUsuario.getPassword() == null || dadosUsuario.getPassword().equals(Constants.EMPTY))
		||  (dadosUsuario.getPhones() == null || dadosUsuario.getPhones().isEmpty())) {
			throw new ApiException(HttpStatus.BAD_REQUEST.value(), DADOS_INVALIDOS);
		}
		
		DateTime now = new DateTime();
		
		Usuario usuario = new Usuario()
				.dadosUsuario(dadosUsuario)
				.id(UUID.randomUUID())
				.created(now)
				.modified(now)
				.lastLogin(now)
				.apiKey(UUID.randomUUID());
		
		this.usuarioRepository.addUsuario(usuario);
		
		return usuario;
	}

	@Override
	public Usuario userProfile(UUID id) throws ApiException {
		Usuario usuario = this.usuarioRepository.findUsuario(id);
		
		if (usuario == null) {
			throw new ApiException(HttpStatus.NOT_FOUND.value(), Constants.USUARIO_NAO_ENCONTRADO);
		}
		
		return usuario;
	}
}
