package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.InlineResponse200UserData;
import java.util.UUID;
import org.joda.time.DateTime;
import javax.validation.constraints.*;
/**
 * InlineResponse200
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-13T22:59:20.852Z")

public class InlineResponse200   {
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
  private InlineResponse200UserData userData = null;

  public InlineResponse200 id(UUID id) {
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

  public InlineResponse200 created(DateTime created) {
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

  public InlineResponse200 modified(DateTime modified) {
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

  public InlineResponse200 lastLogin(DateTime lastLogin) {
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

  public InlineResponse200 apiKey(UUID apiKey) {
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

  public InlineResponse200 userData(InlineResponse200UserData userData) {
    this.userData = userData;
    return this;
  }

   /**
   * Get userData
   * @return userData
  **/
  @ApiModelProperty(value = "")
  public InlineResponse200UserData getUserData() {
    return userData;
  }

  public void setUserData(InlineResponse200UserData userData) {
    this.userData = userData;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse200 inlineResponse200 = (InlineResponse200) o;
    return Objects.equals(this.id, inlineResponse200.id) &&
        Objects.equals(this.created, inlineResponse200.created) &&
        Objects.equals(this.modified, inlineResponse200.modified) &&
        Objects.equals(this.lastLogin, inlineResponse200.lastLogin) &&
        Objects.equals(this.apiKey, inlineResponse200.apiKey) &&
        Objects.equals(this.userData, inlineResponse200.userData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, created, modified, lastLogin, apiKey, userData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse200 {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    modified: ").append(toIndentedString(modified)).append("\n");
    sb.append("    lastLogin: ").append(toIndentedString(lastLogin)).append("\n");
    sb.append("    apiKey: ").append(toIndentedString(apiKey)).append("\n");
    sb.append("    userData: ").append(toIndentedString(userData)).append("\n");
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
}

