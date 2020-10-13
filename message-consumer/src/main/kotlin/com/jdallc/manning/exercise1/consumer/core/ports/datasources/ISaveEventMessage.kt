package com.jdallc.manning.exercise1.consumer.core.ports.datasources

import com.jdallc.manning.exercise1.consumer.core.domain.model.EventRequest
import com.jdallc.manning.exercise1.consumer.core.domain.model.MessageProcessingResult


/**
 * Responsibility: </br>
 * 1. </br>
 * 2. </br>
 * Created By: johndestefano
 * Date: 10/12/20
 */
interface ISaveEventMessage {
    fun saveEventMessage(evtRequest: EventRequest): MessageProcessingResult
}