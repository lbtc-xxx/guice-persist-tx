package app.guice;

import app.service.FirstService;
import app.service.FirstServiceImpl;
import app.service.SecondServiceImpl;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.persist.jpa.JpaPersistModule;

public class MyModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new JpaPersistModule("myJpaUnit"));
    }

    @Provides
    FirstService provideFirstService(final SecondServiceImpl secondServiceImpl) {
        System.out.println(getClass().getName() + "#provideFirstService()");
        return new FirstServiceImpl(secondServiceImpl);
    }
}
