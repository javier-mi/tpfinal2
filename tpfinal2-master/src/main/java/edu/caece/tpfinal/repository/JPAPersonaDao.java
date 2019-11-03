package edu.caece.tpfinal.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import edu.caece.tpfinal.domain.Persona;

@Repository(value = "personaDao")
public class JPAPersonaDao implements IPersonaDao {

    private EntityManager em = null;

    @PersistenceContext
    public void setEntityManager(EntityManager em) throws Exception {
        this.em = em;
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> getPersonas() throws Exception {
		return em.createQuery("SELECT p from persona p").getResultList();
	}

}