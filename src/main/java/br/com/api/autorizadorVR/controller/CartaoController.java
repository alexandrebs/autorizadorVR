package br.com.api.autorizadorVR.controller;

import java.net.URI;

import javax.management.InvalidApplicationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.api.autorizadorVR.dto.CartaoDTO;
import br.com.api.autorizadorVR.exception.InvalidArgumentException;
import br.com.api.autorizadorVR.exception.StandardError;
import br.com.api.autorizadorVR.model.Cartao;
import br.com.api.autorizadorVR.service.CartaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("API Autorizador")
@RestController
@RequestMapping("/cartoes")
public class CartaoController {

	@Autowired
	private CartaoService cartaoService;
	
	
	
	
	@ApiOperation(value = "Inserir Cartao")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created", response = Cartao.class),
			@ApiResponse(code = 400, message = "Bad Request", response = StandardError.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
			@ApiResponse(code = 403, message = "Fordiben", response = StandardError.class),
			@ApiResponse(code = 404, message = "Not Found", response = StandardError.class),
			@ApiResponse(code = 422, message = "Cartão já cadastrado no Autorizador", response = InvalidArgumentException.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = StandardError.class), })
	@PostMapping()
	public ResponseEntity<Cartao> inserirEquipe(@Valid @RequestBody CartaoDTO dto) {

		Cartao cartao = cartaoService.inserirCartao(dto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cartao.getNumeroCartao())
				.toUri();
		return ResponseEntity.created(location).body(cartao);

	}
	
}