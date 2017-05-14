package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class Phone extends BaseModel implements Cloneable {

	@JsonProperty("number")
	private String number = null;
	  
	@JsonProperty("ddd")
	private String ddd = null;
	  
	public Phone number(String number) {
		this.number = number;
		return this;
	}
	
	/**
	* Get number
	* @return number
	**/
	@ApiModelProperty(value = "")
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	  
	public Phone ddd(String ddd) {
		this.ddd = ddd;
		return this;
	}
	
	/**
	* Get ddd
	* @return ddd
	**/
	@ApiModelProperty(value = "")
	public String getDdd() {
		return ddd;
	}
	
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}


	@Override
	public boolean equals(java.lang.Object p) {
		if (this == p) {
			return true;
		}
		if (p == null || getClass() != p.getClass()) {
			return false;
		}
		Phone phone = (Phone) p;
		return Objects.equals(this.number, phone.number) &&
			Objects.equals(this.ddd, phone.ddd);
	}

	@Override
	public int hashCode() {
		return Objects.hash(number, ddd);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Phone {\n");
		
		sb.append("    number: ").append(this.toIndentedString(number)).append("\n");
		sb.append("    ddd: ").append(toIndentedString(ddd)).append("\n");
		sb.append("}");
		return sb.toString();
	}
	
	public Phone clone() {
		return new Phone()
				.number(number)
				.ddd(ddd);
	}
}
