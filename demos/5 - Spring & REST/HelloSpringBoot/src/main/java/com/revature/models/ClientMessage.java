package com.revature.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ClientMessage (HTTP Response Template Model)", description = "This model serves as basic template for all UPDATE/CREATE/DELETE API operations")
public class ClientMessage {
	
	@ApiModelProperty(name="message", 
			notes="a String value that contains the contents of any HTTP response the provided given HTTP verb",
			required = true,
			value = "TEST_MESSAGE")
	private String message;

	public ClientMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClientMessage(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
