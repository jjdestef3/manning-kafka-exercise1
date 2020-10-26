package com.jdallc.manning.exercise1.consumer.core.usecases

import com.jdallc.manning.exercise1.consumer.core.Config
import com.jdallc.manning.exercise1.consumer.core.KafkaConfig
import com.jdallc.manning.exercise1.consumer.core.domain.model.EventRequest
import com.jdallc.manning.exercise1.consumer.core.ports.datasources.ISaveEventMessage
import io.vertx.core.AbstractVerticle
import io.vertx.kafka.client.consumer.KafkaConsumer
import mu.KotlinLogging
import org.apache.kafka.clients.consumer.ConsumerConfig
import java.util.*
import javax.enterprise.context.ApplicationScoped
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
 * Date: 10/13/20
 */
@ApplicationScoped
class EventConsumerVerticle : AbstractVerticle() {

    @Inject
    @field: Default
    lateinit var kafkaConfig: KafkaConfig

    @Inject
    @field: Default
    lateinit var config: Config

    @Inject
    @field: Default
    lateinit var saveEventMessage: ISaveEventMessage

    override fun start() {
        // Configure the consumer
        val consumer =
                KafkaConsumer.create<String, EventRequest>(vertx, Properties().apply {
                    this[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = kafkaConfig.servers
                    this[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = kafkaConfig.keyDeserializer
                    this[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = kafkaConfig.valueDeserializer
                    this[ConsumerConfig.GROUP_ID_CONFIG] = kafkaConfig.groupId
                })

        // Subscribe to topic
        consumer.subscribe(config.kafkaTopic) {
            if (it.succeeded()) {
                logger.info { "Subscribed to topic: ${config.kafkaTopic}" }
            } else {
                logger.info { "Error Subscribing to topic: ${config.kafkaTopic}" }
            }
        }

        // Exception handler
        consumer.exceptionHandler {
            logger.error(it) { "Error it topic consumer for topic ${config.kafkaTopic}" }
        }

        // Handler
        consumer.handler {
            vertx.executeBlocking<Any>({ promise ->
                saveEventMessage.saveEventMessage(it.value())
                promise.complete()
            }, {})
        }
    }
}