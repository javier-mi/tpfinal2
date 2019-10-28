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
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> getUsuarios() {
		return em.createQuery("SELECT u FROM usuario u").getResultList();
	}

	@Override
	public Usuario getUsuarioById(int usuarioId) {
		return null;
	}

	@Override
	public void agregarUsuario(Usuario usuario) {
		
	}

	@Override
	public void eliminarUsuario(int usuarioId) {

	}

}