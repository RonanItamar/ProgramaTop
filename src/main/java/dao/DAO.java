package dao;

import java.util.List;

public interface DAO<T> {
	
	public void salvar(T object);
	
	public void atualizar(T object);

	public List<T> listar();
	
	public void remover(T object);

	public T findById(int id);

	public void fechar();
	
}
