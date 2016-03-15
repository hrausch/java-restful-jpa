package br.com.herbertrausch.domain;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.eclipse.persistence.sessions.Project;



public class ProdutoDAO extends GenericDAO<Produto> {

	public ProdutoDAO() {
		super(Produto.class);
	}
	
	public List<Object []> getNumeroAtributos(){
		
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
		
		Root<Produto> pro = cq.from(Produto.class);
		Join<Produto,ProdutoAtributo> ppa = pro.join("produtos");
		
				
		List<Object []> result = em.createQuery(
				cq.multiselect(pro, cb.count(ppa))
				.groupBy(pro)
				.having(cb.ge(cb.count(ppa),2)) ).getResultList();
		
		return result;
		
		
	}

	@SuppressWarnings("unchecked")
	public List<Object []> getSomaMediaValor(){
		
		EntityManager em = getEntityManager();
		
		List<Object []> result = em.createQuery(
				"SELECT SUM(p.valor), AVG(p.valor) "
				+ "FROM Produto p ").getResultList();

		return result;
		
	}
	
	
	
	


}
