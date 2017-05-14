package io.swagger.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import io.swagger.api.ApiException;
import io.swagger.model.Constants;
import io.swagger.model.Login;
import io.swagger.model.Usuario;

@Repository
public class UsuarioRepository {

	private static UsuarioRepository instance;
	
	private List<Usuario> usuarios;

	private UsuarioRepository() {
		usuarios = new ArrayList<Usuario>();
	}
	
	public static UsuarioRepository Singleton() {
		if (instance == null) {
			return new UsuarioRepository();
		}
		
		return instance;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public UsuarioRepository addUsuario(Usuario usuario) throws ApiException {
		for(Usuario usuarioCadastrado:this.usuarios) {
			if (usuario.getDadosUsuario().getEmail().equals(usuarioCadastrado.getDadosUsuario().getEmail())) {
				throw new ApiException(HttpStatus.BAD_REQUEST.value(), Constants.USUARIO_JA_CADASTRADO);
			}
		}
		
		this.usuarios.add(usuario);
		
		return this;
	}
	
	public Usuario findUsuario(UUID id) {
		for(Usuario usuarioCadastrado:this.usuarios) {
			if (usuarioCadastrado.getId().equals(id)) {
				return usuarioCadastrado;
			}
		}
		
		return null;
	}
	
	public Usuario findUsuario(Login login) {
		if (this.usuarios == null || this.usuarios.isEmpty()) {
			return null;
		}
		
		for(Usuario usuarioCadastrado:this.usuarios) {
			if (usuarioCadastrado.getDadosUsuario().getEmail().equals(login.getEmail())) {
				return usuarioCadastrado;
			}
		}
		
		return null;
		
	}
}
