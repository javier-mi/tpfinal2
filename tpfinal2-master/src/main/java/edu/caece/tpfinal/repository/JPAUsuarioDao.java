package edu.caece.tpfinal.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import edu.caece.tpfinal.domain.Usuario;

@Repository(value = "usuarioDao")
public class JPAUsuarioDao implements IUsuarioDao {

    private EntityManager em = null;

    @PersistenceContext
    public void setEntityManager(EntityManager em) throws Exception {
        this.em = em;
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> getUsuarios() throws Exception {
		return em.createQuery("SELECT u FROM usuario u").getResultList();
	}
	
	@Override
	public Usuario getUsuarioById(int usuarioId) throws Exception {
		return em.createQuery("SELECT u FROM usuario WHERE CAST(u.usuario AS Usuario) u WHERE u.id = :usuarioId", Usuario.class).getSingleResult();
	}
	
	@Override
	public void deleteUsuario(int usuarioId) throws Exception {
		em.createQuery("DELETE FROM usuario WHERE u.id = :usuarioId");
	}
	
	@Override
	public Usuario findById(int id) throws Exception {
		Usuario usuario = null;
        try {
        	usuario = em.find(Usuario.class, id);
        } catch (Exception e) {
			throw new Exception("method findById :: " + e.getMessage());
		}
        return usuario;
    }

	public void deleteUsuarioById(int id) {
        em.createQuery("DELETE FROM usuario WHERE u.id = :usuarioId");
    }

}