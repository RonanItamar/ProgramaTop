package livro.gerenciar;

import dao.GenericDAO;
import jakarta.persistence.TypedQuery;
import java.util.List;
import livro.Livro;

public class LivroDAO extends GenericDAO<Livro>{
    
    public LivroDAO() {
        super(Livro.class);
    }
    
    public List<Livro> buscarTodos() {
        TypedQuery<Livro> q = em.createQuery("SELECT l FROM Livro l", Livro.class);
        return q.getResultList();
    }
    
}
