package com.omisoft.vitafu.utils.plugins.akkaGuice;
import play.Logger;
import play.libs.Akka;

import com.google.inject.Injector;

/**
* Created by bkoprinski on 15-1-23.
*/
public class AkkaGuice {
    private AkkaGuice() { }

    public static void InitializeInjector(Injector injector, String... namespaces) {
        Logger.debug("Initialize Injector");
        GuiceExtension.GuiceProvider.get(Akka.system()).initialize(injector);
        ActorScanner.ScheduleActors();
        ActorScanner.ScheduleOnceActors();
    }
}
