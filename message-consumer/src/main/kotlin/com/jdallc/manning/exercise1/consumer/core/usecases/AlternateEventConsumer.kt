package com.jdallc.manning.exercise1.consumer.core.usecases

import com.jdallc.manning.exercise1.consumer.core.Config
import com.jdallc.manning.exercise1.consumer.core.KafkaConfig
import com.jdallc.manning.exercise1.consumer.core.domain.model.EventRequest
import com.jdallc.manning.exercise1.consumer.core.ports.datasources.ISaveEventMessage
import io.quarkus.runtime.ShutdownEvent
import io.quarkus.runtime.StartupEvent
import mu.KotlinLogging
import org.apache.kafka.clients.consumer.KafkaConsumer
import java.time.Duration
import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.event.Observes
import javax.enterprise.inject.Default
import javax.inject.Inject

/**
 * File logger
 */
private val logger = KotlinLogging.logger {}

/**
 * Responsibility: </br>
 * 1. </br>
 * 2. </br>
 * Created By: johndestefano
 * Date: 10/25/20
 */
@ApplicationScoped
class AlternateEventConsumer : Runnable {

    @Inject
    @field: Default
    lateinit var kafkaConfig: KafkaConfig

    @Inject
    @field: Default
    lateinit var config: Config

    @Inject
    @field: Default
    lateinit var saveEventMessage: ISaveEventMessage

    val consumer =  KafkaConsumer<String, EventRequest>(
            Properties().apply {
                this["bootstrap.servers"] = kafkaConfig.servers
                this["group.id"] = kafkaConfig.groupId
                this["key.deserializer"] = kafkaConfig.keyDeserializer
                this["value.deserializer"] = kafkaConfig.valueDeserializer
            })

    private val scheduler = Executors.newSingleThreadScheduledExecutor()

    fun onStart(@Observes ev: StartupEvent?) {
        scheduler.scheduleWithFixedDelay(this, 0L, 5L, TimeUnit.SECONDS)
    }

    fun onStop(@Observes ev: ShutdownEvent?) {
        scheduler.shutdown()
    }

    override fun run() {
        consumer.subscribe(listOf(config.kafkaTopic))
        logger.info { "Consumer Configured for topic: ${config.kafkaTopic}" }

        while (true) {
            val records = consumer.poll(Duration.ofSeconds(1))
            logger.info("Received ${records.count()} records")

            records.iterator().forEach {
                saveEventMessage.saveEventMessage(it.value())
            }
        }

    }
}