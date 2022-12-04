package br.com.api.autorizadorVR.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.api.autorizadorVR.model.Cartao;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, String> {

	public List<Cartao> findByNumeroCartao(String numeroCartao);

}
