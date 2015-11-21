package app;

import app.app.service.FirstService;
import app.app.service.FirstServiceImpl;
import app.entity.MyEntity;
import app.guice.MyModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistService;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WeirdTransactionalBehaviorTest {
    private static final int PRIMARY_KEY = 1;

    static EntityManagerFactory emf;
    static EntityManager em;

    Injector injector = Guice.createInjector(new MyModule());
    MyEntity myEntity = new MyEntity(PRIMARY_KEY);

    @Before
    public void init() {
        injector.getInstance(PersistService.class).start();
    }

    @Test
    public void shouldBeInsertedForInstanceProducedByProvideMethod() {
        final FirstService sut = injector.getInstance(FirstService.class);

        sut.firstSave(myEntity);
    }

    @Test
    public void shouldBeInsertedWhenInstanceProducedImplicitly() {
        final FirstService sut = injector.getInstance(FirstServiceImpl.class);

        sut.firstSave(myEntity);
    }

    @After
    public void checkInserted() {
        final EntityManager em = injector.getInstance(EntityManager.class);
        final MyEntity myEntity = em.find(MyEntity.class, PRIMARY_KEY);
        em.refresh(myEntity);

        assertThat(myEntity.getId(), is(PRIMARY_KEY));
    }

    @BeforeClass
    public static void initClass() {
        emf = Persistence.createEntityManagerFactory("myJpaUnit");
        em = emf.createEntityManager();
    }

    @AfterClass
    public static void afterClass() {
        em.close();
        emf.close();
    }

    @Before
    public void cleanTable() {
        System.out.println(getClass() + ": cleaning the table before every test begins...");
        em.getTransaction().begin();
        em.createQuery("DELETE FROM MyEntity").executeUpdate();
        em.getTransaction().commit();
    }
}
