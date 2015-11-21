package app.app.service;

import app.entity.MyEntity;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.Optional;

public class ThirdServiceImpl {
    private final EntityManager em;

    @Inject
    public ThirdServiceImpl(final EntityManager em) {
        this.em = em;
    }

    public void thirdSave(final MyEntity myEntity) {
        em.persist(myEntity);
    }
}
