/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuario.gerenciar;

import dao.GenericDAO;
import jakarta.persistence.Query;
import usuario.Usuario;
import java.util.List;

public class UsuarioDAO extends GenericDAO<Usuario> {
    
    public UsuarioDAO() {
        super(Usuario.class);
        
    }
    
    	public List<Usuario> pesquisarSenha(String senha){
            
            String hql = "from Usuario u where u.senha = :senhaParam";
            Query query = em.createQuery(hql);
            query.setParameter("senhaParam", senha);
            
            List<Usuario> senhaPesquisada = query.getResultList();
            
            return senhaPesquisada;
        }
        
        public List<Usuario> pesquisarEmail(String email){
        
            String hql = "from Usuario u where u.email = :emailParam";
            Query query = em.createQuery(hql);
            query.setParameter("emailParam", email);
            
            List<Usuario> emailPesquisado = query.getResultList();
            
            return emailPesquisado;

        }
    
}
