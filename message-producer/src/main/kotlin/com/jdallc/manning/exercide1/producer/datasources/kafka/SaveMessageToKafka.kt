package com.jdallc.manning.exercide1.producer.datasources.kafka

import com.jdallc.manning.exercide1.producer.core.Config
import com.jdallc.manning.exercide1.producer.core.domain.model.EventRequest
import com.jdallc.manning.exercide1.producer.core.domain.model.MessageProcessingResult
import com.jdallc.manning.exercide1.producer.core.ports.datasources.ISaveMessage
import mu.KotlinLogging
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.clients.producer.RecordMetadata
import java.util.*
import javax.annotation.PostConstruct
import javax.annotation.PreDestroy
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Default
import javax.inject.Inject

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
class SaveMessgeToKafka : ISaveMessage {

    @Inject
    @field: Default
    lateinit var config: Config

    @Inject
    @field: Default
    lateinit var kafkaConfig: KafkaConfig

    private lateinit var producer: KafkaProducer<String, EventRequest>

    @PostConstruct
    fun postconstruct() {
        val props = Properties()
        props["bootstrap.servers"] = kafkaConfig.servers
        props["key.serializer"] = kafkaConfig.keySerializer
        props["value.serializer"] = kafkaConfig.valueSerializer
        producer = KafkaProducer<String, EventRequest>(props)
    }

    @PreDestroy
    fun preDestroy() {
        producer.close()
    }

    /**
     * Send the message to Kafka
     */
//    override fun saveMessage(evtRequest: EventRequest): MessageProcessingResult {
//        lateinit var ret: MessageProcessingResult
//        KafkaProducer<String, EventRequest>(kafkaConfig).use { producer ->
//            producer.send(ProducerRecord(config.kafkaTopic,
//                    evtRequest.chargingSource,
//                    evtRequest)) { m: RecordMetadata, e: Exception? ->
//                ret = when (e) {
//                    null -> MessageProcessingResult(true)
//                    else -> {
//                        logger.error { e }
//                        MessageProcessingResult(false, e.message)
//                    }
//                }
//            }.get()
//        }
//        return ret
//    }
    override fun saveMessage(evtRequest: EventRequest): MessageProcessingResult {
        lateinit var ret: MessageProcessingResult
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
        return ret
    }
}