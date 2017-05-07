import com.google.inject.Guice;
import com.google.inject.Injector;
import com.omisoft.vitafu.utils.di.DependencyModule;
import play.Application;
import play.GlobalSettings;
import play.Logger;

/**
 * Created by dido on 11/13/14.
 * Fake Global Config
 */
public class FakeGlobal extends GlobalSettings {

    private Injector injector;


    @Override
    public <A> A getControllerInstance(Class<A> controllerClass) throws Exception {
        return injector.getInstance(controllerClass);
    }


    @Override
    public void onStart(Application app) {
        Logger.info("TEST STARTED");
        injector = Guice.createInjector(new FakeDependencyModule());

    }

    @Override
    public void onStop(Application app) {
        Logger.info("TEST ENDED");
    }
}


