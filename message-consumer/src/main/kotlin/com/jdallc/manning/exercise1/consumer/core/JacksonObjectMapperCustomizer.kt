package com.jdallc.manning.exercise1.consumer.core

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import io.quarkus.jackson.ObjectMapperCustomizer
import javax.inject.Singleton

/**
 * Responsibility: </br>
 * 1. Configure the Jackson Object Mapper</br>
 * 2. </br>
 * Created By: johndestefano
 * Date: 4/6/20
 */
@Singleton
class JacksonObjectMapperCustomizer : ObjectMapperCustomizer {

    override fun customize(objectMapper: ObjectMapper) {
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false)
    }
}