package com.jdallc.manning.exercide1.producer.datasources.kafka

import io.quarkus.arc.config.ConfigProperties
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

    @ConfigProperty(name = "kafka.key.serializer")
    lateinit var keySerializer: String

    @ConfigProperty(name = "kafka.value.serializer")
    lateinit var valueSerializer: String
}