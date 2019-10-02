package edu.caece.tpfinal.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import edu.caece.tpfinal.domain.Usuario;

@Repository(value = "userDao")
public class JPAUsuarioDao implements IUsuarioDao {

    private EntityManager em = null;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

	@Override
	public List<Usuario> getUsuarios() {
		return em.createQuery("select p from usuarios p order by p.id").getResultList();
	}

	@Override
	public Usuario getUsuarioById(int usuarioId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean usuarioExiste(String email, String contrasenia) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void agregarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarUsuario(int usuarioId) {
		// TODO Auto-generated method stub
		
	}

}