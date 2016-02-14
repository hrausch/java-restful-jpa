package br.com.herbertrausch.domain;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class EnderecoDAO extends GenericDAO<Endereco> {

	public EnderecoDAO() {
		super(Endereco.class);
	}

	public List<Endereco> findEnderecosByUf(String uf) {

		EntityManager em = getEntityManager();

		// Fabrica de definicoes de consulta
		CriteriaBuilder cb = em.getCriteriaBuilder();

		// estrutura de consulta
		CriteriaQuery<Endereco> query = cb.createQuery(Endereco.class);
		Root<Endereco> from = query.from(Endereco.class);

		TypedQuery<Endereco> typedQuery = em.createQuery(query.select(from)
				.where(cb.equal(from.get("uf"), uf)));

		List<Endereco> results = typedQuery.getResultList();

		return results;

	}

	public List<Endereco> findEnderecosByCliente(Cliente c) {

		EntityManager em = getEntityManager();

		// Fabrica de definicoes de consulta
		CriteriaBuilder cb = em.getCriteriaBuilder();

		// estrutura de consulta
		CriteriaQuery<Endereco> query = cb.createQuery(Endereco.class);
		Root<Endereco> from = query.from(Endereco.class);

		TypedQuery<Endereco> typedQuery = em.createQuery(query.select(from)
				.where(cb.equal(from.join("cliente").get("id"), c.getId())

				));

		List<Endereco> results = typedQuery.getResultList();

		return results;

	}

	public List<Endereco> findEnderecosByCliente2(Cliente c) {

		EntityManager em = getEntityManager();
		TypedQuery<Endereco> typedQuery = em.createQuery(
				"SELECT e FROM Endereco e WHERE e.cliente=:parametroCliente",
				Endereco.class);

		typedQuery.setParameter("parametroCliente", c);

		List<Endereco> results = typedQuery.getResultList();

		return results;

	}

	public List<Endereco> findEnderecosByClientePaisUf(Cliente c, Pais p,
			String uf) {

		EntityManager em = getEntityManager();

		// Fabrica de definicoes de consulta
		CriteriaBuilder cb = em.getCriteriaBuilder();

		// estrutura de consulta
		CriteriaQuery<Endereco> query = cb.createQuery(Endereco.class);
		Root<Endereco> from = query.from(Endereco.class);

		TypedQuery<Endereco> typedQuery = em
				.createQuery(query.select(from)
						.where(cb.equal(from.join("cliente"), c),
								cb.and(cb.equal(from.join("pais").get("id"),
										p.getId())),
								cb.and(cb.like(from.get("uf"), uf))

						));

		List<Endereco> results = typedQuery.getResultList();

		return results;

	}

}
