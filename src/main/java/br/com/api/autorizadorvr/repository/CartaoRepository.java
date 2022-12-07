package br.com.api.autorizadorvr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.api.autorizadorvr.model.Cartao;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, String> {

	public List<Cartao> findByNumeroCartao(String numeroCartao);

	
	@Query(name="Consultar Saldo",
			value = " SELECT c.valor as saldo FROM miniautorizador.cartao c where  c.numerocartao = ? ",
			nativeQuery= true
			)
	public Object consultarSaldo(String numeroCartao);
}
