package com.jdallc.manning.exercise1.consumer.core.usecases

import com.jdallc.manning.exercise1.consumer.core.domain.model.EventRequest
import com.jdallc.manning.exercise1.consumer.core.ports.api.IEventConsumerUC
import com.jdallc.manning.exercise1.consumer.core.ports.datasources.ISaveEventMessage
import io.smallrye.reactive.messaging.annotations.Blocking
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.eclipse.microprofile.reactive.messaging.Incoming
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Default
import javax.inject.Inject
import javax.inject.Named
import javax.transaction.Transactional

/**
 * Responsibility: </br>
 * 1. </br>
 * 2. </br>
 * Created By: johndestefano
 * Date: 10/13/20
 */
@ApplicationScoped
class EventConsumerReactiveStreamsUC : IEventConsumerUC {

    @Inject
    @field: Default
    lateinit var saveEventMessage: ISaveEventMessage

    @Incoming("event")
    @Blocking
    @Transactional
    override fun processKafkaMessage(record: EventRequest) {
        saveEventMessage.saveEventMessage(record)
    }
}