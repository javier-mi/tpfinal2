package edu.caece.tpfinal.repository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.caece.tpfinal.domain.Usuario;

@Transactional
@Repository
public class UsuarioDAO implements IUsuarioDao {
	
	@PersistenceContext	
	private EntityManager entityManager;	
	
	@Override
	public Usuario getUsuarioById(int usuarioId) {
		return entityManager.find(Usuario.class, usuarioId);
	}

	@Override
	public void agregarUsuario(Usuario usuario) {
		entityManager.persist(usuario);
	}
	
	@Override
	public void eliminarUsuario(int usuarioId) {
		entityManager.remove(usuarioId);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> getUsuarios() {
		String hql = "FROM usuario as u";
		return (List<Usuario>) entityManager.createQuery(hql).getResultList();
	}

} 