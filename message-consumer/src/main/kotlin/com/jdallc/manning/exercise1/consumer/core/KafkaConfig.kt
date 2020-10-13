package com.jdallc.manning.exercise1.consumer.core

import org.eclipse.microprofile.config.inject.ConfigProperty
import javax.enterprise.context.ApplicationScoped

/**
 * Responsibility: </br>
 * 1. </br>
 * 2. </br>
 * Created By: johndestefano
 * Date: 10/12/20
 */
@ApplicationScoped
class KafkaConfig {
    @ConfigProperty(name = "kafka.bootstrap.servers")
    lateinit var servers: String

    @ConfigProperty(name = "kafka.acks")
    lateinit var acks: String

    @ConfigProperty(name = "kafka.key.deserializer")
    lateinit var keyDeserializer: String

    @ConfigProperty(name = "kafka.value.deserializer")
    lateinit var valueDeserializer: String

    @ConfigProperty(name = "kafka.group.id")
    lateinit var groupId: String
}