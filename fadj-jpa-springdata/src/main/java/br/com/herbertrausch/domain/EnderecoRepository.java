package br.com.herbertrausch.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

	public interface EnderecoRepository extends CrudRepository<Endereco, Long> {


	public List<Endereco> findEnderecosByUf(String uf);
	
	public List<Endereco> findEnderecosByCliente(Cliente c);
	
	public List<Endereco> findEnderecosByClienteAndPaisAndUf(Cliente c, Pais p, String uf);
}
