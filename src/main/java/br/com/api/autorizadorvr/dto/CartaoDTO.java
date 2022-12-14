package br.com.api.autorizadorvr.dto;

import java.io.Serializable;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CartaoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String numeroCartao;
	@NotBlank
	private String senha;
	
	//private Long valor;

}
