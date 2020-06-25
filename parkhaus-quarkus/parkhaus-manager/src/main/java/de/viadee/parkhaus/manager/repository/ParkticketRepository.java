package de.viadee.parkhaus.manager.repository;


import de.viadee.parkhaus.manager.entity.Parkticket;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional(rollbackOn = Exception.class)
public class ParkticketRepository {

    final EntityManager em;

    @Inject
    public ParkticketRepository(EntityManager em) {
        this.em = em;
    }

    public void persist(Parkticket parkticket) {
        em.persist(parkticket);
    }

    public List<Parkticket> findAll() {
        return em.createQuery("select s from Parkticket s", Parkticket.class).getResultList();
    }

    public Parkticket findById(String id) {
        return em.find(Parkticket.class, id);
    }
}
