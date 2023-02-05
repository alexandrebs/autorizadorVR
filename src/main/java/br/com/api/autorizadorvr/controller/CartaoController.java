package br.com.api.autorizadorvr.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.NotFound;
import org.springframework.web.client.HttpClientErrorException.UnprocessableEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.api.autorizadorvr.dto.CartaoDTO;
import br.com.api.autorizadorvr.dto.SaldoDTO;
import br.com.api.autorizadorvr.exception.InvalidArgumentException;
import br.com.api.autorizadorvr.exception.StandardError;
import br.com.api.autorizadorvr.model.Cartao;
import br.com.api.autorizadorvr.service.CartaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("API Autorizador")
@RestController
@RequestMapping()
public class CartaoController {

	@Autowired
	private CartaoService cartaoService;
	

	@PostMapping("/cartoes")
	public ResponseEntity<Cartao> inserirCartao(@Valid @RequestBody CartaoDTO dto) throws Exception, UnprocessableEntity  {

		Cartao cartao = cartaoService.inserirCartao(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(cartao);

	}
	

	@GetMapping("/cartoes/{numeroCartao}")
	public ResponseEntity<Object> consultarSaldo(@PathVariable("numeroCartao") String numeroCartao) {
		return ResponseEntity.ok().body(cartaoService.consultarSaldo(numeroCartao) );
	}
	
	

	@PostMapping("/transacoes")
	public ResponseEntity<Cartao> realizarTransacao( @Valid @RequestBody Cartao cartao) throws Exception {
		cartaoService.autorizarCartao(cartao);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(cartao);


	}
	
}
