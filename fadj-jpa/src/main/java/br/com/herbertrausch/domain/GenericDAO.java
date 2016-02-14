package br.com.herbertrausch.domain;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class GenericDAO<T> {
	
	private static final String PERSISTENCEUNIT = "fadjjdbc";
	
	protected EntityManagerFactory emf;
	private Class<T> type;

	    public GenericDAO(Class<T> classe) {
	    	
	        type = classe;
	        emf = Persistence.createEntityManagerFactory(PERSISTENCEUNIT);
	    }
	    
	    public EntityManager getEntityManager() {
	        return emf.createEntityManager();
	    }
	    
		/**
		 * Recebe um objeto e insere no banco de dados.
		 * @param Recebe um objeto que quer inserir no banco de dados.
		 */
	    public T create(T t) {
	    	
	    	EntityManager em = null;
	        try {
	            em = getEntityManager();
	            em.getTransaction().begin();
	            em.persist(t);
	            em.getTransaction().commit();
	            em.close();
	            return t;
	        }catch(Exception e){
	            e.printStackTrace();
	        } 
	        
	        return t;
	    }

	    /**
	     * Remove do banco de dados uma tupla a partir da chave primária.
	     * @param Valor da chave primária que deseja remover.
	     */
	    public void delete(Object id) {
	    	EntityManager em = null;
	    	em = getEntityManager();
	    	em.getTransaction().begin();
	        em.remove(em.getReference(type, id));
	        em.getTransaction().commit();
	        em.close();
	    }

	    /**
	     * Procura um tupla de um objeto a partir da chave primária.
	     * @param Valor da chave primária da tupla que está pesquisando.
	     */
	    public T findById(Object id) {
	    	EntityManager em = null;
	    	em = getEntityManager();
	        return (T) em.find(type, id);
	        
	    }

	    /**
	     * Atualiza no banco de dados a tupla representada pelo objeto que é recebido como parâmetro.
	     * @param objeto que será atualizado no banco de dados.
	     */
	    public T update(T t) {
	    	EntityManager em = getEntityManager();
	    	em.getTransaction().begin();
	    	t = em.merge( t );
	    	 em.flush();
	        em.getTransaction().commit();
	        em.close();
	    	
	       
	        return t;
	    }

	    /**
	     * Retorna uma lista com todas as tuplas de uma entidade
	     */
		@SuppressWarnings("unchecked")
		public ArrayList<T> findEntities() {
			 EntityManager em = getEntityManager();
		        try {
		            CriteriaQuery<T> cq = em.getCriteriaBuilder().createQuery(type);
		            
		            cq.select(cq.from(type));
		            Query q = em.createQuery(cq);

		            ArrayList<T> arrayListResult = new ArrayList<T>();
		            arrayListResult.addAll( q.getResultList() );
		            
		            return arrayListResult;
		            
		        } finally {
		            em.close();
		        }
		}
		
		/**
		 * Retorna a quantidade de tuplas de uma entidade
		 */
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public int getEntitiesCount(){
			
			EntityManager em = getEntityManager();
	        try {
	            CriteriaQuery cq = em.getCriteriaBuilder().createQuery(type);
	            Root<T> rt = cq.from(type);
	            cq.select(em.getCriteriaBuilder().count(rt));
	            Query q = em.createQuery(cq);
	            return ((Long) q.getSingleResult()).intValue();
	        } finally {
	            em.close();
	        }
		}

}
