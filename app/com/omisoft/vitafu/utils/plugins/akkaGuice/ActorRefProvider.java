package com.omisoft.vitafu.utils.plugins.akkaGuice;
import play.libs.Akka;
import akka.actor.Actor;
import akka.actor.ActorRef;

import com.google.inject.Provider;

import java.util.Random;


/**
* Created by bkoprinski on 15-1-23.
*/
class ActorRefProvider implements Provider<ActorRef> {
    private final Class<? extends Actor> actor;
    private final String key;
    private final Random rnd = new Random();
    private final boolean singleton;

    public ActorRefProvider(Class<? extends Actor> actor, String key, boolean singleton) {
        this.actor = actor;
        this.key = key;
        this.singleton = singleton;

    }

    @Override
    public ActorRef get() {
        if(singleton) return Akka.system().actorOf(GuiceExtension.GuiceProvider.get(Akka.system()).props(actor), key);
        final String name = key + "-" + Math.abs(rnd.nextLong());
        return Akka.system().actorOf(GuiceExtension.GuiceProvider.get(Akka.system()).props(actor), name);
    }
}