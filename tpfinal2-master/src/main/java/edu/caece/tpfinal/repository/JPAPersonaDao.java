package edu.caece.tpfinal.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import edu.caece.tpfinal.domain.Persona;
import edu.caece.tpfinal.domain.Usuario;

@Repository(value = "personaDao")
public class JPAPersonaDao implements IPersonaDao {

    private EntityManager em = null;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> getPersonas() {
		return em.createQuery("SELECT p from persona p").getResultList();
	}

	@Override
	public Persona getPersonaById(int personaId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregarPersona(Persona personaId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarPersona(int personaId) {
		// TODO Auto-generated method stub
		
	}

}