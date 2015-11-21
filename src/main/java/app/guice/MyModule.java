package app.guice;

import app.app.service.FirstService;
import app.app.service.FirstServiceImpl;
import app.app.service.SecondServiceImpl;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.persist.jpa.JpaPersistModule;

import javax.inject.Provider;

public class MyModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new JpaPersistModule("myJpaUnit"));
    }

//    @Provides
//    SecondServiceImpl provideSecondService(final ThirdServiceImpl thirdServiceImpl) {
//        return new SecondServiceImpl(thirdServiceImpl);
//    }

    @Provides
    FirstService provideFirstService(final Provider<SecondServiceImpl> secondServiceImplProvider) {
        return new FirstServiceImpl(secondServiceImplProvider);
    }
}
