package com.omisoft.vitafu.utils.plugins.akkaGuice;
import akka.actor.Actor;
import akka.actor.IndirectActorProducer;

import com.google.inject.Injector;

/**
* Created by bkoprinski on 15-1-23.
*/
class GuiceInjectedActor implements IndirectActorProducer {
    final Injector injector;
    final Class<? extends Actor> actorClass;

    public GuiceInjectedActor(Injector injector, Class<? extends Actor> actorClass) {
        this.injector = injector;
        this.actorClass = actorClass;
    }

    public Class<? extends Actor> actorClass() {
        return actorClass;
    }

    public Actor produce() {
        return injector.getInstance(actorClass);
    }
}