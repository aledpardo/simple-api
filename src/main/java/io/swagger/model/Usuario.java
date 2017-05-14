package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.DadosUsuario;
import java.util.UUID;
import org.joda.time.DateTime;
import javax.validation.constraints.*;
/**
 * Usuario
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-13T22:59:20.852Z")

public class Usuario implements Cloneable  {
  @JsonProperty("id")
  private UUID id = null;

  @JsonProperty("created")
  private DateTime created = null;

  @JsonProperty("modified")
  private DateTime modified = null;

  @JsonProperty("last_login")
  private DateTime lastLogin = null;

  @JsonProperty("api_key")
  private UUID apiKey = null;

  @JsonProperty("user_data")
  private DadosUsuario dadosUsuario = null;

  public Usuario id(UUID id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Usuario created(DateTime created) {
    this.created = created;
    return this;
  }

   /**
   * Get created
   * @return created
  **/
  @ApiModelProperty(value = "")
  public DateTime getCreated() {
    return created;
  }

  public void setCreated(DateTime created) {
    this.created = created;
  }

  public Usuario modified(DateTime modified) {
    this.modified = modified;
    return this;
  }

   /**
   * Get modified
   * @return modified
  **/
  @ApiModelProperty(value = "")
  public DateTime getModified() {
    return modified;
  }

  public void setModified(DateTime modified) {
    this.modified = modified;
  }

  public Usuario lastLogin(DateTime lastLogin) {
    this.lastLogin = lastLogin;
    return this;
  }

   /**
   * Get lastLogin
   * @return lastLogin
  **/
  @ApiModelProperty(value = "")
  public DateTime getLastLogin() {
    return lastLogin;
  }

  public void setLastLogin(DateTime lastLogin) {
    this.lastLogin = lastLogin;
  }

  public Usuario apiKey(UUID apiKey) {
    this.apiKey = apiKey;
    return this;
  }

   /**
   * Get apiKey
   * @return apiKey
  **/
  @ApiModelProperty(value = "")
  public UUID getApiKey() {
    return apiKey;
  }

  public void setApiKey(UUID apiKey) {
    this.apiKey = apiKey;
  }

  public Usuario dadosUsuario(DadosUsuario dadosUsuario) {
    this.dadosUsuario = dadosUsuario;
    return this;
  }

   /**
   * Get dadosUsuario
   * @return dadosUsuario
  **/
  @ApiModelProperty(value = "")
  public DadosUsuario getDadosUsuario() {
    return dadosUsuario;
  }

  public void setDadosUsuario(DadosUsuario dadosUsuario) {
    this.dadosUsuario = dadosUsuario;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Usuario usuario = (Usuario) o;
    return Objects.equals(this.id, usuario.id) &&
        Objects.equals(this.created, usuario.created) &&
        Objects.equals(this.modified, usuario.modified) &&
        Objects.equals(this.lastLogin, usuario.lastLogin) &&
        Objects.equals(this.apiKey, usuario.apiKey) &&
        Objects.equals(this.dadosUsuario, usuario.dadosUsuario);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, created, modified, lastLogin, apiKey, dadosUsuario);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Usuario {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    modified: ").append(toIndentedString(modified)).append("\n");
    sb.append("    lastLogin: ").append(toIndentedString(lastLogin)).append("\n");
    sb.append("    apiKey: ").append(toIndentedString(apiKey)).append("\n");
    sb.append("    dadosUsuario: ").append(toIndentedString(dadosUsuario)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  public Usuario clone() {
	  return new Usuario()
			  .id(id)
			  .apiKey(apiKey)
			  .created(created)
			  .modified(modified)
			  .lastLogin(lastLogin)
			  .dadosUsuario(
					  dadosUsuario == null 
			  		  ? null 
					  : dadosUsuario.clone()
			  );
  }
}

