package com.kimberly.apirest.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Component
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseOfService implements Serializable {
	
	private static final long serialVersionUID = 3232544603993458597L;
	
	private String code = "";
	
	private String message = "";
	
	private Object response = null;
	
}
