package app.app.service;


import app.entity.MyEntity;
import com.google.inject.persist.Transactional;

import javax.inject.Inject;

public class FirstServiceImpl implements FirstService {

    private final SecondServiceImpl secondServiceImpl;

    @Inject
    public FirstServiceImpl(final SecondServiceImpl secondServiceImpl) {
        this.secondServiceImpl = secondServiceImpl;
    }

    @Override
    @Transactional
    public void firstSave(final MyEntity myEntity) {
        secondServiceImpl.secondSave(myEntity);
    }
}
