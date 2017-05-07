package com.omisoft.vitafu.utils.plugins.akkaGuice;
import java.util.*;

import javax.inject.Named;

import akka.actor.AbstractActor;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import play.Logger;
import akka.actor.Actor;
import akka.actor.ActorRef;
import akka.actor.UntypedActor;

import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.Singleton;
import com.google.inject.name.Names;

/**
* Created by bkoprinski on 15-1-23.
*/
public class AkkaGuiceModule extends AbstractModule {
    private final static List<String> ignore;

    static {
        ignore = new ArrayList<String>();
        ignore.add("AbstractLoggingActor");
        ignore.add("AbstractActorWithStash");
        ignore.add("UntypedActorWithUnrestrictedStash");
        ignore.add("AbstractActorWithUnrestrictedStash");
        ignore.add("UntypedActorWithUnboundedStash");
        ignore.add("UntypedActorWithStash");
        ignore.add("AbstractActorWithUnboundedStash");
    }


    protected void configure() {
        RegisterActors(binder());
    }

    private static void RegisterActors(Binder binder) {
        Logger.debug("Actor Scanner Started...");
        final Map<String, ActorHolder> map = new HashMap<>();
        final ConfigurationBuilder configBuilder = build();
        final Reflections reflections = new Reflections(configBuilder.setScanners(new SubTypesScanner()));
        final Set<Class<? extends UntypedActor>> actors = reflections.getSubTypesOf(UntypedActor.class);
        final Set<Class<? extends AbstractActor>> abstractActors = reflections.getSubTypesOf(AbstractActor.class);
        loopOnActors(map, actors);
        loopOnAbstractActors(map, abstractActors);
        if(!map.isEmpty()) Logger.debug("Registering actors: ");
        for(final String key : map.keySet()) {
            final ActorHolder actorHolder = map.get(key);
            final Class<? extends Actor> actor = actorHolder.getActor();
            if(actorHolder.isSingleton()) {
                Logger.debug("Binding class " + actor.getSimpleName() + " to name: " + key + " Singleton Scoped.");
                binder.bind(ActorRef.class).annotatedWith(Names.named(key)).toProvider(new ActorRefProvider(actor, key, true)).in(Singleton.class);
            } else {
                Logger.debug("Binding class " + actor.getSimpleName() + " to name: " + key + " Request Scoped.");
                binder.bind(ActorRef.class).annotatedWith(Names.named(key)).toProvider(new ActorRefProvider(actor, key, false));
                PropsContext.put(key, actorHolder);
            }
        }
    }

    private static void loopOnAbstractActors(Map<String, ActorHolder> map, Set<Class<? extends AbstractActor>> actors) {
        for(final Class<? extends Actor> actor : actors) {
            if(ignore.contains(actor.getSimpleName())) continue;
            final String named = getNamed(actor);
            final boolean isSingleton = isSingleton(actor);
            final ActorHolder actorHolder = new ActorHolder(actor, isSingleton);
            if(named != null) {
                map.put(named, actorHolder);
            } else {
                if(map.containsKey(actor.getSimpleName())){
                    map.put(actor.getName(), actorHolder);
                    final ActorHolder tempHolder = map.remove(actor.getSimpleName());
                    map.put(tempHolder.getActor().getName(), tempHolder);
                }
                else map.put(actor.getSimpleName(), actorHolder);
            }
        }
    }

    private static void loopOnActors(Map<String, ActorHolder> map, Set<Class<? extends UntypedActor>> actors) {
        for(final Class<? extends Actor> actor : actors) {
            if(ignore.contains(actor.getSimpleName())) continue;
            final String named = getNamed(actor);
            final boolean isSingleton = isSingleton(actor);
            final ActorHolder actorHolder = new ActorHolder(actor, isSingleton);
            if(named != null) {
                map.put(named, actorHolder);
            } else {
                if(map.containsKey(actor.getSimpleName())){
                    map.put(actor.getName(), actorHolder);
                    final ActorHolder tempHolder = map.remove(actor.getSimpleName());
                    map.put(tempHolder.getActor().getName(), tempHolder);
                }
                else map.put(actor.getSimpleName(), actorHolder);
            }
        }
    }

    private static String getNamed(Class<? extends Actor> actor) {
        if(actor.getAnnotation(Named.class) == null) return null;
        Named named = actor.getAnnotation(Named.class);
        return named.value();
    }

    private static boolean isSingleton(Class<? extends Actor> actor) {
        return actor.getAnnotation(Singleton.class) != null || actor.getAnnotation(javax.inject.Singleton.class) != null;
    }

    private static ConfigurationBuilder build() {
        final ConfigurationBuilder configBuilder = new ConfigurationBuilder();
        configBuilder.addClassLoaders(ClasspathHelper.classLoaders(AkkaGuicePlugin.getClassLoader()));
        configBuilder.addUrls(ClasspathHelper.forClassLoader(AkkaGuicePlugin.getClassLoader()));
        return configBuilder;
    }
}
