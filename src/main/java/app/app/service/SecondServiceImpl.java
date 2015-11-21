package app.app.service;


import app.entity.MyEntity;

import javax.inject.Inject;

public class SecondServiceImpl {

    private final ThirdServiceImpl thirdService;

    @Inject
    public SecondServiceImpl(final ThirdServiceImpl thirdService) {
        this.thirdService = thirdService;
    }

    public void secondSave(final MyEntity myEntity) {
        thirdService.thirdSave(myEntity);
    }
}
