package com.jdallc.manning.exercide1.producer.core.domain.model

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.apache.kafka.common.serialization.Serializer


/**
 * Responsibility: </br>
 * 1. </br>
 * 2. </br>
 * Created By: johndestefano
 * Date: 10/12/20
 */
class EventRequestSerializer : Serializer<EventRequest> {
    override fun serialize(topic: String?, data: EventRequest?): ByteArray? =
            when (data) {
                null -> null
                else -> jacksonObjectMapper().writeValueAsBytes(data)
            }

    override fun close() {}
    override fun configure(configs: MutableMap<String, *>?, isKey: Boolean) {}
}
