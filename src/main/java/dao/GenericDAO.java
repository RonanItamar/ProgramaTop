package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import mysql.MysqlSingleton;

public abstract class GenericDAO<T> implements DAO<T> {

	protected EntityManagerFactory emf;
	protected EntityManager em;
	private Class<T> classe;
	
	public GenericDAO(Class<T> classe) {
		emf = MysqlSingleton.getInstance();
		em = emf.createEntityManager();
		this.classe = classe;
	}

	public void salvar(T object) {
		em.getTransaction().begin();
		em.persist(object);
		em.getTransaction().commit();
	}

	public void atualizar(T object) {
		em.getTransaction().begin();
		em.merge(object);
		em.getTransaction().commit();
	}

	
	@SuppressWarnings("unchecked")
	public List<T> listar() {
		String hql = "from " + classe.getSimpleName() + " order by id desc";
		Query query = em.createQuery(hql);
		query.setMaxResults(20);
		
		return query.getResultList();
	}

	public void remover(T object) {
		em.getTransaction().begin();
		em.remove(object);
		em.getTransaction().commit();
	}

	public T findById(int id) {
		return em.find(classe, id);
	}

	public void fechar() {
		em.close();
		emf.close();
	}
	
	
}
