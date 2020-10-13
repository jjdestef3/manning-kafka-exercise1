package com.jdallc.manning.exercide1.producer.core.domain.model

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.apache.kafka.common.serialization.Deserializer

/**
 * Responsibility: </br>
 * 1. </br>
 * 2. </br>
 * Created By: johndestefano
 * Date: 10/12/20
 */
class EventRequestDeserializer : Deserializer<EventRequest> {
    override fun deserialize(topic: String?, data: ByteArray?): EventRequest? =
            when (data) {
                null -> null
                else -> jacksonObjectMapper().readValue(data, EventRequest::class.java)

            }

    override fun close() {}
    override fun configure(configs: MutableMap<String, *>?, isKey: Boolean) {}
}