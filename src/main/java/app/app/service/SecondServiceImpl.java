package app.app.service;

import app.entity.MyEntity;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class SecondServiceImpl {
    private final EntityManager em;

    @Inject
    public SecondServiceImpl(final EntityManager em) {
        this.em = em;
    }

    // This make both tests work but I can't put @Transactional here for the code at job! :(
    // @com.google.inject.persist.Transactional
    public void secondSave(final MyEntity myEntity) {
        em.persist(myEntity);
    }
}
