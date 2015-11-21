package app.app.service;


import app.entity.MyEntity;
import com.google.inject.persist.Transactional;

import javax.inject.Inject;
import javax.inject.Provider;

public class FirstServiceImpl implements FirstService {

    private final Provider<SecondServiceImpl> secondServiceImpl;

    @Inject
    public FirstServiceImpl(final Provider<SecondServiceImpl> secondServiceImpl) {
        this.secondServiceImpl = secondServiceImpl;
    }

    @Override
    public void firstSave(final MyEntity myEntity) {
        firstSave0(myEntity);
    }

    @Transactional
    void firstSave0(final MyEntity myEntity) {
        secondServiceImpl.get().secondSave(myEntity);
    }
}
