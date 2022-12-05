package br.com.api.autorizadorVR.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.autorizadorVR.dto.CartaoDTO;
import br.com.api.autorizadorVR.exception.InvalidArgumentException;
import br.com.api.autorizadorVR.exception.NotFoundException;
import br.com.api.autorizadorVR.model.Cartao;
import br.com.api.autorizadorVR.repository.CartaoRepository;

@Service
public class CartaoService {

	@Autowired
	private CartaoRepository cartaoRepository;

	@Autowired
	private ModelMapper modelMapper;

	public Cartao buscarCartaoId(String numeroCartao) {
		return cartaoRepository.findById(numeroCartao)
				.orElseThrow(() -> new NotFoundException("Nenhum cartão encontrado com o número " + numeroCartao));
	}

	public Cartao inserirCartao(CartaoDTO dto) {

		if (cartaoRepository.existsById(dto.getNumeroCartao())) {
			throw new InvalidArgumentException("Ja existe um cartão cadastro com o número " + dto.getNumeroCartao());
		}
		Cartao cartao = new Cartao();
		cartao = modelMapper.map(dto, Cartao.class);
		cartao.setValor(500F);
		cartaoRepository.save(cartao);

		return cartao;

	}

	public Object consultarSaldo(String numeroCartao) {

		Object saldoDto = cartaoRepository.consultarSaldo(numeroCartao);

		if (saldoDto == null) {
			throw new NotFoundException("Saldo não enconrado para o cartão informado nº " + numeroCartao);
		}

		return saldoDto;
	}

	public Cartao autorizarCartao(Cartao cartao) {

		//cartaoRepository.findById(cartao.getNumeroCartao()).orElseThrow(() -> new NotFoundException("Nenhum cartão encontrado com o número " + cartao.getNumeroCartao()));
		
		
		Optional<Cartao> cartaoRetorno = cartaoRepository.findById(cartao.getNumeroCartao());
		
		
		if (!cartaoRetorno.isPresent()) {
			throw new InvalidArgumentException("CARTAO_INEXISTENTE");
		}

		if (!cartao.getSenha().equals(cartaoRetorno.get().getSenha())) {
			throw new InvalidArgumentException("SENHA_INVALIDA");
		}

		if (cartao.getValor() > cartaoRetorno.get().getValor()) {
			throw new InvalidArgumentException("SALDO_INSUFICIENTE");
		}
		cartaoRetorno.get().debitarValor(cartao.getValor()) ;
		cartao.setValor(cartaoRetorno.get().getValor());
		return cartaoRepository.save(cartao);
		
	}

}
