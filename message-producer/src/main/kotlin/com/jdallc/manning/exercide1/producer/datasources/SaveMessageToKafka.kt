package com.jdallc.manning.exercide1.producer.datasources

import com.jdallc.manning.exercide1.producer.core.Config
import com.jdallc.manning.exercide1.producer.core.domain.model.EventRequest
import com.jdallc.manning.exercide1.producer.core.domain.model.MessageProcessingResult
import com.jdallc.manning.exercide1.producer.core.ports.datasources.ISaveMessage
import mu.KotlinLogging
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.clients.producer.RecordMetadata
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Default
import javax.inject.Inject
import javax.inject.Named

// File logger
private val logger = KotlinLogging.logger {}

/**
 * Responsibility: </br>
 * 1. </br>
 * 2. </br>
 * Created By: johndestefano
 * Date: 10/11/20
 */
@ApplicationScoped
class SaveMessgeToKafkaa : ISaveMessage {

    @Inject
    @field: Named("default-kafka-broker")
    lateinit var kafkaConfig: Map<String, Any>

    @Inject
    @field: Default
    lateinit var config: Config

    /**
     * Send the message to Kafka
     */
    override fun saveMessage(evtRequest: EventRequest): MessageProcessingResult {
        lateinit var ret: MessageProcessingResult
        KafkaProducer<String, EventRequest>(kafkaConfig).use { producer ->
            producer.send(ProducerRecord(config.kafkaTopic,
                    evtRequest.chargingSource,
                    evtRequest)) { m: RecordMetadata, e: Exception? ->
                ret = when (e) {
                    null -> MessageProcessingResult(true)
                    else -> {
                        logger.error { e }
                        MessageProcessingResult(false, e.message)
                    }
                }
            }.get()
        }
        return ret
    }
}