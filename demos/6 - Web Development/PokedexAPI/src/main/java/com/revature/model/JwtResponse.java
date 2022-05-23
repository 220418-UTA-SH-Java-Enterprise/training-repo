package com.revature.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class JwtResponse implements Serializable{
	private static final long serialVersionUID = -8526218486236690654L;

	private final String jwttoken;
}
