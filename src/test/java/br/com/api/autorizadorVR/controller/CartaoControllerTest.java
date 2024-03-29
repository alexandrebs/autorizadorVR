package br.com.api.autorizadorVR.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.api.autorizadorvr.dto.CartaoDTO;
import br.com.api.autorizadorvr.model.Cartao;
import br.com.api.autorizadorvr.repository.CartaoRepository;
import br.com.api.autorizadorvr.service.CartaoService;

@SpringBootTest
@AutoConfigureMockMvc
@FixMethodOrder()
public class CartaoControllerTest {

	private Cartao cartao;

	private CartaoDTO cartaoDto;


     @MockBean private CartaoService cartaoService;

	 @MockBean private CartaoRepository cartaoRepository;


	private ModelMapper modelMapper;


	private ObjectMapper objectMapper;

	@Autowired
	MockMvc mockMvc;

	@BeforeEach
	public void setUp() throws Exception {
		cartao = new Cartao();
		cartao.setNumeroCartao("6549873025634501");
		cartao.setSenha("1234");
		cartao.setValor(10F);

		cartaoDto = new CartaoDTO();
		cartaoDto.setNumeroCartao(cartao.getNumeroCartao());
		cartaoDto.setSenha(cartao.getSenha());

	}
	
	

	@DisplayName(value = "Inserir Cartão") 
	@Test
	public void inserirCartao1() throws Exception {

/*
		mockMvc.perform(post("/cartoes", cartao)
						.contentType("Application/json"))
				.andExpectAll(status().isOk());
*/
	}

	@DisplayName(value = "Consultar Saldo")
	@Test
	public void consultarSaldo2() throws Exception {

		/*
		mockMvc.perform(
				get("/cartoes/{numeroCartao}", cartao.getNumeroCartao())
				.param("numeroCartao", cartao.getNumeroCartao())
				.contentType("Application/json")
				.content(objectMapper.writeValueAsString(cartao.getValor())))
				.andExpect(status().isOk());
*/
	}

	@DisplayName(value = "Realizar transação")
	@Test
	public void realizarTransacao3() throws Exception {

		/*
		mockMvc.perform(post("/transacoes", cartao).contentType("Application/json")
				.content(objectMapper.writeValueAsString(cartao)))
				.andExpect(status().isCreated()); */
	}

	@DisplayName(value = "Inserir cartão Existente")
	@Test
	public void inserirCartaoExistente4() throws Exception {

		/*
		cartao.setValor(null);
		mockMvc.perform(
				post("/cartoes")
				.contentType("Application/json")
				.content(objectMapper.writeValueAsString(422)))
				.andExpectAll(status().is(400)); */
						
	}
	
	@DisplayName(value = "Saldo insuficiente")
	@Test
	public void realizarTransacao_SaldoInsuficiente() throws Exception {
		/*
		mockMvc.perform(post("/transacoes", cartao)
				.contentType("Application/json"))
				.andExpectAll(status().is(400));

		 */
	}
}
