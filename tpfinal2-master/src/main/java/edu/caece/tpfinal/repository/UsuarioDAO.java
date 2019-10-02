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

	@Override
	public boolean usuarioExiste(String email, String contrasenia) {
		String hql = "FROM usuarios as u WHERE u.email = ? and u.contrasenia = ?";
		int count = entityManager.createQuery(hql)
				    .setParameter(1, email)
		            .setParameter(2, contrasenia).getResultList().size();
		return count > 0 ? true : false;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> getUsuarios() {
		String hql = "FROM usuarios as u ORDER BY u.id";
		return (List<Usuario>) entityManager.createQuery(hql).getResultList();
	}

} 