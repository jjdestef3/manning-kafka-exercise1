package com.jdallc.manning.exercise1.consumer.core.ports.api

import com.jdallc.manning.exercise1.consumer.core.domain.model.EventRequest
import org.apache.kafka.clients.consumer.ConsumerRecord


/**
 * Responsibility: </br>
 * 1. </br>
 * 2. </br>
 * Created By: johndestefano
 * Date: 10/12/20
 */
interface IEventConsumerUC {
    fun consumeMessage() = Unit
    fun shutdown() = Unit
    fun processKafkaMessage(record: EventRequest) = Unit
}