package com.omisoft.vitafu.utils.plugins.akkaGuice;
import akka.actor.AbstractExtensionId;
import akka.actor.Actor;
import akka.actor.ExtendedActorSystem;
import akka.actor.Extension;
import akka.actor.Props;

import com.google.inject.Injector;

/**
* Created by bkoprinski on 15-1-23.
*/
public class GuiceExtension extends AbstractExtensionId<GuiceExtension.GuiceExt> {
    public static GuiceExtension GuiceProvider = new GuiceExtension();

    public GuiceExt createExtension(ExtendedActorSystem system) {
        return new GuiceExt();
    }

    public static class GuiceExt implements Extension {
        private volatile Injector injector;

        public void initialize(Injector injector) {
            this.injector = injector;
        }

        public Props props(Class<? extends Actor> actorClass) {
            return Props.create(GuiceInjectedActor.class, injector, actorClass);
        }

        Injector getInjector() {
            return injector;
        }
    }
}