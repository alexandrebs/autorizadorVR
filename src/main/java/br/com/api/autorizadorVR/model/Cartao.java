package br.com.api.autorizadorVR.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="cartao")
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cartao {

	@Id
	@Column(name = "numerocartao", unique = true, nullable = false)
	private String numeroCartao;

	@Column(name = "senha")
	private String senha;

	@Column(name = "valor")
	private Long valor;

}
