package com.jdallc.manning.exercise1.consumer

import com.jdallc.manning.exercise1.consumer.core.usecases.EventConsumerVerticle
import io.quarkus.runtime.StartupEvent
import io.vertx.core.Vertx
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.event.Observes


/**
 * Responsibility: </br>
 * 1. </br>
 * 2. </br>
 * Created By: johndestefano
 * Date: 10/13/20
 */
@ApplicationScoped
class VerticleDeployer {
    fun init(@Observes e: StartupEvent?, vertx: Vertx, verticle: EventConsumerVerticle?) {
        // vertx.deployVerticle(verticle)
    }
}