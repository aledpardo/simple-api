package io.swagger.service;

import io.swagger.api.ApiException;
import io.swagger.model.Usuario;

public interface Login {
	Usuario loginUser(io.swagger.model.Login login) throws ApiException;
}
