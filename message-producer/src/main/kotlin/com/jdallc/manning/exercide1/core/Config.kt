package com.jdallc.manning.exercide1.core

import io.quarkus.arc.config.ConfigProperties

/**
 * Responsibility: </br>
 * 1. </br>
 * 2. </br>
 * Created By: johndestefano
 * Date: 2/3/20
 */
@ConfigProperties(prefix = "app")
class Config {
    lateinit var name: String
    lateinit var serviceVersion: String
    lateinit var serviceDescription: String
    lateinit var kafkaTopic: String
}