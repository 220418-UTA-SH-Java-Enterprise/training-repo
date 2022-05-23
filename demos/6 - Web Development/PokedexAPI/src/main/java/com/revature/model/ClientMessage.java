package com.revature.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ApiModel(value = "ClientMessage (HTTP Response Template Model)", description = "This model serves as basic template for all UPDATE/CREATE/DELETE API operations")
public class ClientMessage {
	
	@ApiModelProperty(name="message", 
			notes="a String value that contains the contents of any HTTP response the provided given HTTP verb",
			required = true,
			value = "TEST_MESSAGE")
	private String message;
}
