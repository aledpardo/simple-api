package io.swagger.service;

import java.util.UUID;

import io.swagger.api.ApiException;
import io.swagger.model.Usuario;
import io.swagger.model.DadosUsuario;

public interface Cadastro {

	Usuario addUser(DadosUsuario dadosUsuario) throws ApiException;
	
	Usuario userProfile(UUID apiKey, UUID id) throws ApiException;
}
