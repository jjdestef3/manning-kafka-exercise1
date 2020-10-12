package com.jdallc.manning.exercide1.producer.core.domain.model

import io.quarkus.runtime.annotations.RegisterForReflection

/**
 * Responsibility: </br>
 * 1. Indicate the result of saving a message</br>
 * 2. If result is false then you must populate the message</br>
 * Created By: johndestefano
 * Date: 10/11/20
 */
@RegisterForReflection
data class MessageProcessingResult(val result: Boolean, val message: String? = null)