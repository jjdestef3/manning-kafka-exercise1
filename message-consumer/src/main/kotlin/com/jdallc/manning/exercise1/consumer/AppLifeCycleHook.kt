package com.jdallc.manning.exercise1.consumer

import com.jdallc.manning.exercise1.consumer.core.ports.api.IEventConsumerUC
import io.quarkus.runtime.StartupEvent
import mu.KotlinLogging
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.event.Observes
import javax.enterprise.inject.Default
import javax.inject.Inject

/**
 * File Logger
 */
private val logger = KotlinLogging.logger {}


/**
 * Responsibility: </br>
 * 1. Start up the message consumer</br>
 * 2. </br>
 * Created By: johndestefano
 * Date: 10/12/20
 */
@ApplicationScoped
class AppLifeCycleHook {

    @Inject
    @field: Default
    lateinit var eventConsumerUC: IEventConsumerUC

    fun onStart(@Observes ev: StartupEvent?) {
        logger.info { "Starting Consume ...." }
        eventConsumerUC.consumeMessage()
    }
}