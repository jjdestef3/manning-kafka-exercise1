package com.jdallc.manning.exercise1.consumer.core.usecases

import com.fasterxml.jackson.databind.ObjectMapper
import com.jdallc.manning.exercise1.consumer.core.Config
import com.jdallc.manning.exercise1.consumer.core.KafkaConfig
import com.jdallc.manning.exercise1.consumer.core.domain.model.EventRequest
import com.jdallc.manning.exercise1.consumer.core.ports.api.IEventConsumerUC
import com.jdallc.manning.exercise1.consumer.core.ports.datasources.ISaveEventMessage
import io.quarkus.runtime.Startup
import mu.KotlinLogging
import org.apache.kafka.clients.consumer.KafkaConsumer
import java.time.Duration
import java.util.*
import javax.annotation.PostConstruct
import javax.annotation.PreDestroy
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
 * Date: 10/12/20
 */
@Startup
@ApplicationScoped
class EventConsumerUC : IEventConsumerUC {

    @Inject
    @field: Default
    lateinit var kafkaConfig: KafkaConfig

    @Inject
    @field: Default
    lateinit var config: Config

    @Inject
    @field: Default
    lateinit var objectMapper: ObjectMapper

    @Inject
    @field: Default
    lateinit var saveEventMessage: ISaveEventMessage

    private lateinit var consumer: KafkaConsumer<String, EventRequest>

    /**
     * Configure the consumer
     */
    @PostConstruct
    fun postConstruct() {
        val props = Properties()
        props["bootstrap.servers"] = kafkaConfig.servers
        props["group.id"] = kafkaConfig.groupId
        props["key.deserializer"] = kafkaConfig.keyDeserializer
        props["value.deserializer"] = kafkaConfig.valueDeserializer
        consumer = KafkaConsumer<String, EventRequest>(props)
    }

    @PreDestroy
    fun preDestroy() {
        logger.info { "In preDestroy" }
        consumer.close()
    }

    override fun shutdown() {
        consumer.close()
    }

    /**
     * Message consumer
     */
    override fun consumeMessage() {
        consumer.subscribe(listOf(config.kafkaTopic))
        while (true) {
            val records = consumer.poll(Duration.ofSeconds(1))
            records.iterator().forEach {
                saveEventMessage.saveEventMessage(it.value())
            }
        }
    }

}