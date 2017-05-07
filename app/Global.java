import com.google.inject.Guice;
import com.google.inject.Injector;
import com.omisoft.vitafu.utils.plugins.akkaGuice.AkkaGuice;
import com.omisoft.vitafu.utils.plugins.akkaGuice.AkkaGuiceModule;
import com.omisoft.vitafu.utils.di.DependencyModule;
import play.Application;
import play.GlobalSettings;
import play.Logger;


/**
 * Global settings run with app
 * Created by dido on 10/16/14.
 */
public class Global extends GlobalSettings {
    private Injector injector;


    @Override
    public <A> A getControllerInstance(Class<A> controllerClass) throws Exception {
        return injector.getInstance(controllerClass);
    }


    @Override
    public void onStart(Application app) {
        Logger.info("VITAFU  has startedlj");

        // Akka Guice initialization
        injector = Guice.createInjector(new AkkaGuiceModule(), new DependencyModule());
        AkkaGuice.InitializeInjector(injector);

    }

    @Override
    public void onStop(Application app) {
        Logger.info("VITAFU shutdown...");
    }
}
